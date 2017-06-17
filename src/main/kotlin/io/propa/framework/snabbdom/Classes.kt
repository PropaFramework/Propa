package io.propa.framework.snabbdom

import io.propa.framework.external.snabbdom.Classes
import io.propa.framework.external.snabbdom.set

/**
 * Created by gbaldeck on 6/17/2017.
 */
fun Classes.add(vararg classes: String){
  classes.forEach {
    value ->
    set(value, true)
  }
}

fun Classes.remove(vararg classes: String){
  classes.forEach {
    value ->
    set(value, false)
  }
}

fun Classes.addAll(vararg classes: String){
  add(*classes)
}

fun Classes.removeAll(vararg classes: String){
  remove(*classes)
}

operator fun Classes.plusAssign(className: String){
  add(className)
}

operator fun Classes.minusAssign(className: String){
  remove(className)
}