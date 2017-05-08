package com.gbsol.propa

import com.gbsol.propa.core.*
import kotlinx.html.body
import org.w3c.dom.HTMLElement
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/17/2017.
 */
object Propa {
  val renderer = PropaDomBuilder<HTMLElement>(document)

  inline fun<reified T: PropaComponent> entryComponent(component: PropaComponentRenderer<T>){
    val propaTree = Propa.renderer.startPropa(component.createInstance())

    try {
      document.body!!.append(propaTree)
    } catch (e: Exception){
      throwPropaException("No body element defined.")
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