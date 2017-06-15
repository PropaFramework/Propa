package io.propa.framework.component

import io.propa.framework.external.Math

/**
 * Created by gbaldeck on 5/10/2017.
 */
object PropaComponentManager{
  internal val tree = PropaComponentTree()
  val map = mutableMapOf<String, PropaComponent>()

  var componentsInheritStyle = false

  val possibleLetters: dynamic = "abcdefghijklmnopqrstuvwxyz"
  val possibleNumbers: dynamic = "0123456789"

  fun generatePropaId(): String {
    var text: String

    do {
      text = "propa-"

      for (i in 0..6) {
        if(i.rem(2) == 0)
          text += possibleLetters.charAt(Math.floor(Math.random() * possibleLetters.length))
        else
          text += possibleNumbers.charAt(Math.floor(Math.random() * possibleNumbers.length))
      }

    } while (map.contains(text))

    return text;
  }
}