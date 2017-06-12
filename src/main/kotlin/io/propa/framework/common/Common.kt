package io.propa.framework.common

import io.propa.framework.external.snabbdom._get
import io.propa.framework.external.snabbdom._set
import kotlin.reflect.KProperty

/**
 * Created by gbaldeck on 5/7/2017.
 */
internal fun String.camelToDashCase(): String {
  return this.replace(Regex("([a-z])([A-Z])"), {
        result ->
          val (g1: String, g2: String) = result.destructured
          "$g1-$g2"
      }).toLowerCase()
}

internal fun String.getProperTagName(): String =
  if (this.indexOf("-") > 0)
    this.toLowerCase()
  else
    throwPropaException("The chosen tag name '$this' is not in the correct custom tag format.")

fun jsObjectOf(vararg pairs: Pair<String, dynamic>): dynamic{
  val obj: dynamic = Any()
  pairs.forEach {
    (key, value) ->
    obj[key] = value
  }
  return obj
}

fun jsObjectOf(map: Map<String, dynamic>): dynamic = jsObjectOf(*map.toList().toTypedArray())

class DelegateProperty(val backingObj: Any, val propertyName: String? = null){
  operator fun getValue(thisRef: Any?, property: KProperty<*>): dynamic {
    return backingObj._get(propertyName ?: property.name)
  }

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: dynamic) {
    backingObj._set(propertyName ?: property.name, value)
  }
}