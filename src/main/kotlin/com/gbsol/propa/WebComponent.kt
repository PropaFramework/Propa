package com.gbsol.propa

import org.w3c.dom.CustomElementRegistry
import org.w3c.dom.HTMLSlotElement
import org.w3c.dom.Window
import kotlin.browser.window

/**
 * Created by gbaldeck on 5/4/2017.
 */
abstract class MyWebComponent: PropaElementTest() {
  companion object {}

  init {
    console.log("My custom element is made!")
  }
}

fun CustomElementRegistry.define(name: String, constructor: JsClass<*>) {
  window.customElements.define(name, constructor as () -> dynamic)
}

external open class HTMLElement

external open class PropaElementTest