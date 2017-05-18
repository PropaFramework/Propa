package com.gbsol.propa.common

import com.gbsol.propa.core.throwPropaException

/**
 * Created by gbaldeck on 5/7/2017.
 */
fun String.camelToDashCase(): String {
  return this.replace(Regex("([a-z])([A-Z])"), {
        result ->
          val (g1: String, g2: String) = result.destructured
          "$g1-$g2"
      }).toLowerCase()
}

fun String.getProperTagName(): String =
  if (this.indexOf("-") > 0)
    this.toLowerCase()
  else
    throwPropaException("The chosen tag name '$this' is not in the correct custom tag format.")