package io.propa.framework.dom

import io.propa.framework.common.jsArrayOf
import io.propa.framework.core.PropaComponent
import io.propa.framework.external.snabbdom.*

/**
 * Created by gbaldeck on 6/4/2017.
 */
class PropaDomBuilder{
  lateinit var patch: Patch
  private set

  fun startPropa(component: PropaComponent? = null){
    patch = Snabbdom.init(jsArrayOf(SnabbClass, SnabbProps, SnabbStyle, SnabbEventListeners))
  }
}