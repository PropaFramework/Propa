package io.propa.framework.common

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