package io.propa.framework.core

import io.propa.framework.common.camelToDashCase
import io.propa.framework.common.createInstance
import io.propa.framework.common.getProperTagName
import io.propa.framework.common.throwPropaException
import kotlinx.html.HtmlBlockTag
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

  val scopeAttributes = mutableMapOf<String, String>() //for use in giving the css scope to each element in the template

  val element: Element
    get() {
      val target: Element? = document.querySelector("${getComponentTagName()}[$propaId]")

      return target ?: throwPropaException("Element '${getComponentTagName()}' with propa-id '$propaId' was not found.")
    }

  abstract fun template(): PropaTemplate
}

fun PropaComponent.getComponentTagName(): String =
    if (this.tagName.trim() == "")
      this::class.simpleName!!.camelToDashCase()
    else
      this.tagName.getProperTagName()


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


fun PropaComponent.generateStyleAndScope(){
  if(styleCompiled == null) {
    styleCompiled = this.style?.replace(CssRegex(), {
      result ->
      val (selectors, rules) = result.destructured
      recursiveApplyCssAttr(selectors)+rules
    })
  }
  recursiveInheritedStyleScope(this)
}

fun recursiveInheritedStyleScope(component: PropaComponent,
                                 scopeAttributes: MutableMap<String, String> = component.scopeAttributes){
  if(component.treeNode == null)
    throwPropaException("A tree node has not been generated for this component.")

  scopeAttributes[component.propaId] = ""

  val treeNode = component.treeNode!!
  if(treeNode.parent == null || !component.inheritStyle)
    return

  recursiveInheritedStyleScope(treeNode.parent.component, scopeAttributes)
}

fun PropaComponent.recursiveApplyCssAttr(selectorsStr: String, delimiters: MutableList<String> = mutableListOf(" ",",",">","+","~")): String{
  if(delimiters.isEmpty())
    return "$selectorsStr[$propaId]"

  val del = delimiters.removeAt(0);
  val selectors = selectorsStr.split(del)

  var returnStr = "";

  for(sel in selectors) {
    if(sel.trim() !="") {
      if (sel === selectors.last())
        returnStr += recursiveApplyCssAttr(sel, mutableListOf(*delimiters.toTypedArray()))
      else
        returnStr += recursiveApplyCssAttr(sel, mutableListOf(*delimiters.toTypedArray())) + del
    }
  }

  return returnStr
}

object CssRegex{
  private val regex = Regex("""((?:[^{}"']|'[^']*'|"[^"]*")+)((?:[\s\n]|\/\*(?:(?!\*\/)[\s\S])*\*\/)*{(?:[^{}"']|\/\*(?:(?!\*\/)[\s\S])*\*\/|'[^']*'|"[^"]*")*})""")
  operator fun invoke() = regex
}