package io.propa.framework.component

import io.propa.framework.common.PropaAssignOnce
import io.propa.framework.common.camelToDashCase
import io.propa.framework.common.createInstance
import io.propa.framework.common.getProperTagName
import io.propa.framework.dom.PropaDomBuilder
import io.propa.framework.dom.PropaDomElement
import io.propa.framework.dom.PropaTemplate
import kotlin.collections.set

/**
 * Created by gbaldeck on 4/21/2017.
 */

abstract class PropaComponent: PropaDomElement() {
  val propaId: String = PropaComponentManager.generatePropaId()

  final override var selector: String = ""
    get() {
      if (field.trim() == "")
        field = this::class.simpleName!!.camelToDashCase()

      return field.getProperTagName()
    }

  open var stylesheet: String? = null
  open var inheritStyle: Boolean = PropaComponentManager.componentsInheritStyle

  internal val stylesheetId: String
    get() = propaId+"-stylesheet"
  internal var stylesheetCompiled: String? = null
  internal val scopeAttributes = mutableMapOf<String, String>() //for use in giving the css scope to each element in the template
  internal var treeNode: PropaComponentTreeNode
      by PropaAssignOnce("The component '$selector' has no corresponding tree node.")

  abstract fun template(): PropaTemplate
}

interface PropaComponentBuilder<T : PropaComponent>

inline operator fun <reified T : PropaComponent> PropaComponentBuilder<T>.invoke(noinline block: T.() -> Unit = {}) {
  val component = createInstance()
  component.block()
  PropaDomBuilder.buildComponent(component)
}

inline fun <reified T : PropaComponent> PropaComponentBuilder<T>.createInstance(): T {
  val component = T::class.createInstance()
  return component
}


fun PropaComponent.generateStyleAndScope(){
  if(stylesheetCompiled == null) {
    stylesheetCompiled = this.stylesheet?.replace(CSS_REGEX, {
      result ->
      val (selectors, rules) = result.destructured
      recursiveApplyCssAttr(selectors)+rules
    })
  }

  recursiveInheritedStyleScope(this)
  applyAttributes(*scopeAttributes.toList().toTypedArray())
}

private fun recursiveInheritedStyleScope(component: PropaComponent,
                                         scopeAttributes: MutableMap<String, String> = component.scopeAttributes){
  scopeAttributes[component.propaId] = ""

  if(component.inheritStyle) {
    component.treeNode.parent?.let {
      recursiveInheritedStyleScope(it.component, scopeAttributes)
    }
  }
}

private fun PropaComponent.recursiveApplyCssAttr(selectorsStr: String, delimiters: MutableList<String> = mutableListOf(" ",",",">","+","~")): String{
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

private val CSS_REGEX = Regex("""((?:[^{}"']|'[^']*'|"[^"]*")+)((?:[\s\n]|\/\*(?:(?!\*\/)[\s\S])*\*\/)*{(?:[^{}"']|\/\*(?:(?!\*\/)[\s\S])*\*\/|'[^']*'|"[^"]*")*})""")