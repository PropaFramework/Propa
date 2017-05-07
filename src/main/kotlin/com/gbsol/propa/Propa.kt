package com.gbsol.propa

import kotlinx.html.body
import org.w3c.dom.HTMLElement
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/17/2017.
 */
object with
object withWrapper {
  inline infix fun<reified T: PropaComponent> component(component: PropaComponentRenderer<T>){
    Propa.entryComponent(component)
  }
}

object Propa {
  infix fun start(w: with) = withWrapper
  val renderer = PropaDomBuilder<HTMLElement>(document)

  inline fun<reified T: PropaComponent> entryComponent(component: PropaComponentRenderer<T>){
    val body = Propa.renderer.body { component {} }
    document.body!!.replaceWith(body)
  }
}