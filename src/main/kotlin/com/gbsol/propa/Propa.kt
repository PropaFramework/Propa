package com.gbsol.propa

import com.gbsol.propa.core.*
import com.gbsol.propa.xhtml.removeAllChildren
import org.w3c.dom.HTMLElement
import org.w3c.dom.get
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/17/2017.
 */
object Propa {
  val renderer = PropaDomBuilder<HTMLElement>(document)
  val componentMap = mutableMapOf<String, PropaComponent>()

  fun addComponent(component: PropaComponent){
    componentMap[component.propaId] = component
  }

  inline fun<reified T: PropaComponent> entryComponent(component: PropaComponentRenderer<T>){
    val componentInstance = component.createInstance()
    val propaTree = Propa.renderer.startPropa(componentInstance)

    try {
      val propaApp = document.getElementsByTagName("propa-app")
      with(propaApp[0]!!) {
        removeAllChildren()
        append(propaTree)
      }
    } catch (e: Exception){
      throwPropaException("No propa-app element defined.")
    }

    componentMap.forEach {
      (k, v) ->
      console.log(v.getComponentTagName()+": "+k)
      console.log(v.element)
    }
  }

  infix fun start(w: with) = withWrapper
}

object with
object withWrapper {
  inline infix fun<reified T: PropaComponent> component(component: PropaComponentRenderer<T>){
    Propa.entryComponent(component)
  }
}