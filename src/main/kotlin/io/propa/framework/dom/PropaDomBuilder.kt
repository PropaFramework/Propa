package io.propa.framework.dom

import io.propa.framework.component.PropaComponent
import io.propa.framework.component.PropaComponentManager
import io.propa.framework.external.snabbdom.*
import org.w3c.dom.Element

/**
 * Created by gbaldeck on 6/4/2017.
 */
object PropaDomBuilder{
  lateinit var patch: Patch
  private set

  private var currentElem: PropaDomElement? = null

  fun startPropa(rootElement: Element, component: PropaComponent){
    patch = Snabbdom.init(arrayOf(classModule, attributesModule, propsModule, styleModule, eventListenersModule, datasetModule))
    buildComponent(component)
    patch(rootElement, component.vnode)
  }

  fun buildComponent(component: PropaComponent){
    PropaComponentManager.tree.startComponent(component)
    build(component, { template() })
    PropaComponentManager.tree.finishComponent(component)
  }

  fun buildTag(selector: String, block: PropaDomElement.() -> Unit){
    build(PropaDomElement(selector), block)
  }

  private fun <T: PropaDomElement> build(elem: T, block: T.() -> Unit){
    val previousElem = currentElem
    currentElem = elem
    elem.block()
    elem.vnode = h(elem.selector, elem.vnodeData, elem.children)
    previousElem?.let {
      it.children[it.children.size] = elem.vnode
      currentElem = it
    }
  }
}