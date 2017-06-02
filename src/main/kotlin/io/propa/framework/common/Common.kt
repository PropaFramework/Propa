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

fun jsObjectOf(vararg pairs: Pair<String, Any?>): dynamic{
  js("var obj = {}")
  pairs.forEach {
    (key, value) ->
    js("obj[key] = value")
  }
  return js("obj")
}

fun jsObjectOf(map: Map<String, Any?>): dynamic = jsObjectOf(*map.toList().toTypedArray())

fun jsArrayOf(vararg items: Any?): dynamic{
  js("var obj = []")
  items.forEach {
    value ->
    js("obj.push(value)")
  }
  return js("obj")
}

fun jsArrayOf(list: List<Any?>): dynamic = jsArrayOf(*list.toTypedArray())