package io.propa.framework.external.snabbdom

/**
 * Created by gbaldeck on 6/9/2017.
 */
fun Any._get(key: dynamic): dynamic {
  val self: dynamic = this
  return self[key]
}

fun Any._set(key: dynamic, value: dynamic){
  val self: dynamic = this
  self[key] = value
}