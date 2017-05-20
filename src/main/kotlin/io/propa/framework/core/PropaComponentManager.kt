package io.propa.framework.core

import org.w3c.dom.HTMLElement
import kotlin.browser.document

/**
 * Created by gbaldeck on 5/10/2017.
 */
object PropaComponentManager{
  val renderer = PropaDomBuilder<HTMLElement>(document)
  internal val tree = PropaComponentTree()
  val map = mutableMapOf<String, PropaComponent>()

  var componentsInheritStyle = false

  fun generatePropaId(): String {
    var text: String
    val possibleLetters = "abcdefghijklmnopqrstuvwxyz"
    val possibleNumbers = "0123456789"

    do {
      text = "propa-"

      for (i in 0..6) {
        if(i.rem(2) == 0)
          js("text += possibleLetters.charAt(Math.floor(Math.random() * possibleLetters.length))")
        else
          js("text += possibleNumbers.charAt(Math.floor(Math.random() * possibleNumbers.length))")
      }

    } while (map.contains(text))

    return text;
  }
}