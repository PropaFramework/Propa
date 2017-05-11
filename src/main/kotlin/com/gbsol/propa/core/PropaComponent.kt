package com.gbsol.propa.core

import com.gbsol.propa.Propa
import com.gbsol.propa.common.camelToDashCase
import com.gbsol.propa.common.createInstance
import com.gbsol.propa.common.isProperTagName
import kotlinx.html.HtmlBlockTag
import kotlinx.html.impl.DelegatingMap
import org.w3c.dom.Element
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/21/2017.
 */
abstract class PropaComponent {
  val propaId: String = PropaComponentManager.generatePropaId()
  var treeNode: PropaComponentTreeNode? = null
    get() {
      if(field == null)
        throwPropaException("The component '${getComponentTagName()}' has no corresponding tree node.")

      return field
    }

  var styleCompiled: String? = null

  open var tagName: String = "" //the get() of this should only be used in getComponentTagName()
    protected set

  open var classes: String? = null

  open var style: String? = null

  open var inheritStyle: Boolean = PropaComponentManager.componentsInheritStyle

  open val extraAttributes: Map<String, String> = mutableMapOf()

  val element: Element
    get() {
      var target: Element? = document.querySelector("[$propaId]")

      return target ?: throwPropaException("Element '${getComponentTagName()}' with propa-id '$propaId' was not found.")
    }

  abstract fun template(): PropaTemplate
}

fun PropaComponent.getComponentTagName(): String =
    if (this.tagName.trim() == "")
      this::class.simpleName!!.camelToDashCase()
    else
      this.tagName.isProperTagName()


typealias PropaTemplate = HtmlBlockTag.() -> Unit

interface PropaComponentRenderer<T : PropaComponent>

inline operator fun <reified T : PropaComponent> PropaComponentRenderer<T>.invoke(noinline block: T.() -> Unit = {}) {
  val component = this.createInstance()
  component.block()
  PropaComponentManager.renderer.insertPropaComponent(component)
}

inline fun <reified T : PropaComponent> PropaComponentRenderer<T>.createInstance(): T {
  val component = T::class.createInstance()
  return component
}

fun PropaComponent.getAttributes(): Map<String, String> {
  val attributes = linkedMapOf<String, String>()

  this.classes?.let { attributes["class"] = it.trim() }
  this.extraAttributes.forEach { (key, value) -> attributes[key.trim()] = value.trim() }

  return attributes
}


fun PropaComponent.generateStyleAndScope(attributes: DelegatingMap){
  if(styleCompiled == null) {
    styleCompiled = this.style?.replace(CssRegex(), {
      result ->
      var finalStr = ""
      val selectors = ",>+~{"
      for (i in 1..result.groupValues.size) {
        val group = result.groupValues[i]
        finalStr += group
        if (group.trim() != "" && !selectors.contains(group.trim()))
          finalStr = recursiveInheritedStyleScope(finalStr, this, attributes)
      }
      finalStr
    })

    //if styleCompiled is still null then the component has no set style property
    if(styleCompiled == null)
      recursiveInheritedStyleScope(this, attributes)
  } else {
    recursiveInheritedStyleScope(this, attributes)
  }
}

fun recursiveInheritedStyleScope(stringAcc: String, component: PropaComponent, attributes: DelegatingMap): String{
  if(component.treeNode == null)
    throwPropaException("A tree node has not been generated for this component.")

  attributes[component.propaId] = ""
  val nextStr = "$stringAcc[${component.propaId}]"

  val treeNode = component.treeNode!!
  if(treeNode.parent == null || !component.inheritStyle)
    return nextStr

  return recursiveInheritedStyleScope(nextStr, treeNode.parent.component, attributes)
}

fun recursiveInheritedStyleScope(component: PropaComponent, attributes: DelegatingMap){
  if(component.treeNode == null)
    throwPropaException("A tree node has not been generated for this component.")

  attributes[component.propaId] = ""

  val treeNode = component.treeNode!!
  if(treeNode.parent == null || !component.inheritStyle)
    return

  recursiveInheritedStyleScope(treeNode.parent.component, attributes)
}

object CssRegex{
  private val regex = Regex("(?:([^{}\\s,+>~]+)(\\s*))(?:([,+>~])|(?:(\\s*)([^{}\\s,+>~]+)(\\s*)))*({)")
  operator fun invoke() = regex
}