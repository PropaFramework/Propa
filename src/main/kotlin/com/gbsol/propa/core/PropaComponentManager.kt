package com.gbsol.propa.core

import org.w3c.dom.HTMLElement
import kotlin.browser.document

/**
 * Created by gbaldeck on 5/10/2017.
 */
object PropaComponentManager{
  val renderer = PropaDomBuilder<HTMLElement>(document)
  val tree = PropaComponentTree()
  val map = mutableMapOf<String, PropaComponent>()

  var componentsInheritStyle = false

  fun generatePropaId(): String {
    var text: String

    do {
      text = "propa-"
      val possible = "abcdefghijklmnopqrstuvwxyz0123456789"

      for (i in 0..4)
        js("text += possible.charAt(Math.floor(Math.random() * possible.length))")

    } while (map.contains(text))

    return text;
  }
}