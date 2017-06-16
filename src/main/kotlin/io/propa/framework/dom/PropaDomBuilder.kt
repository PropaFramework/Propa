package io.propa.framework.dom

import io.propa.framework.component.PropaComponent
import io.propa.framework.component.PropaComponentManager
import io.propa.framework.component.generateStyleAndScope
import io.propa.framework.external.snabbdom.*
import org.w3c.dom.Element
import kotlin.browser.document

/**
 * Created by gbaldeck on 6/4/2017.
 */
typealias PropaTemplate = PropaDomBuilder.() -> Unit

object PropaDomBuilder {
  val patch: Patch = Snabbdom.init(arrayOf(classModule, attributesModule, propsModule, styleModule, eventListenersModule, datasetModule))
  private var currentElem: PropaDomElement? = null

  fun buildComponent(component: PropaComponent) {
    PropaComponentManager.tree.startComponent(component)
    generateStylesheet(component)
    build(component, component.template())
    PropaComponentManager.tree.finishComponent(component)
  }

  fun buildTag(selector: String, block: PropaTemplate) {
    build(PropaDomElement(selector), block)
  }

  private fun <T : PropaDomElement> build(elem: T, block: PropaTemplate) {
    val previousElem = currentElem
    currentElem = elem
    this.block()
    elem.vnode = h(elem.selector, elem.vnodeData, elem.children)
    previousElem?.let {
      it.children[it.children.size] = elem.vnode
      currentElem = it
    }
  }

  private fun generateStylesheet(component: PropaComponent) {
    component.generateStyleAndScope()
    component.stylesheetCompiled?.let {
      val style: dynamic = document.createElement("style")
      style.type = "text/css"
      style.appendChild(document.createTextNode(it))
      style.setAttribute("id", component.stylesheetId)
      document.head?.appendChild(style)
    }
  }

  operator fun String.unaryPlus(){
    currentElem?.apply {
      children[children.size] = this@unaryPlus
    }
  }
}