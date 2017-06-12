package io.propa.framework.dom

import io.propa.framework.core.PropaComponent
import io.propa.framework.external.snabbdom.*
import org.w3c.dom.Element

/**
 * Created by gbaldeck on 6/4/2017.
 */
object PropaDomBuilder{
  lateinit var patch: Patch
  private set

  lateinit private var currentVnode: VNode

  fun startPropa(rootElement: Element, component: PropaComponent){
    patch = Snabbdom.init(arrayOf(classModule, attributesModule, propsModule, styleModule, eventListenersModule, datasetModule))
    component
  }
}