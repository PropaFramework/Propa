package io.propa.framework.dom

import com.github.snabbdom.*
import io.propa.framework.common.PropaDelegateProperty
import io.propa.framework.common.throwPropaException
import io.propa.framework.component.PropaComponent
import io.propa.framework.component.PropaComponentManager
import io.propa.framework.component.generateStyleAndScope
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
    val elem = PropaDomElement(selector)
    elem.applyAttributes(*PropaComponentManager.tree.currentNode.component.scopeAttributes.toList().toTypedArray())
    build(elem, block)
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

  private val getCurrentElemVnodeData = { currentElem?.vnodeData ?:
      throwPropaException("There is currently no element to get the vnodeData object from.") }

  val hero: Hero by PropaDelegateProperty(getCurrentElemVnodeData)
  val attachData: AttachData by PropaDelegateProperty(getCurrentElemVnodeData)
  val hook: Hooks by PropaDelegateProperty(getCurrentElemVnodeData)
  var ns: String? by PropaDelegateProperty(getCurrentElemVnodeData)
  var fn: (() -> VNode)? by PropaDelegateProperty(getCurrentElemVnodeData)
  val args: Array<dynamic> by PropaDelegateProperty(getCurrentElemVnodeData)
  val props: Props by PropaDelegateProperty(getCurrentElemVnodeData)
  val attrs: Attrs by PropaDelegateProperty(getCurrentElemVnodeData)
  val classes: Classes by PropaDelegateProperty(getCurrentElemVnodeData, "class")
  val styles: VNodeStyle by PropaDelegateProperty(getCurrentElemVnodeData, "style")
  val dataset: Dataset by PropaDelegateProperty(getCurrentElemVnodeData)
  val on: On by PropaDelegateProperty(getCurrentElemVnodeData)
  var key: dynamic by PropaDelegateProperty(getCurrentElemVnodeData)
}