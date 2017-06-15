package io.propa.framework

import io.propa.framework.common.removeAllChildren
import io.propa.framework.common.throwPropaException
import io.propa.framework.component.PropaComponent
import io.propa.framework.component.PropaComponentBuilder
import io.propa.framework.component.createInstance
import io.propa.framework.dom.PropaDomBuilder
import org.w3c.dom.get
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/17/2017.
 */
object Propa {

  //todo: Make an infix function that sets the PropaComponentManager.componentsInheritStyle property

  inline fun<reified T: PropaComponent> entryComponent(component: PropaComponentBuilder<T>){
    val componentInstance = component.createInstance()

    try {
      val propaApp = document.getElementsByTagName("propa-app")[0]
      propaApp!!.removeAllChildren()
      PropaDomBuilder.startPropa(propaApp, componentInstance)
    } catch (e: Exception){
      throwPropaException("No propa-app element defined.")
    }
  }

  infix fun start(w: with) = withWrapper
}

object with
object withWrapper {
  inline infix fun<reified T: PropaComponent> component(component: PropaComponentBuilder<T>){
    Propa.entryComponent(component)
  }
}