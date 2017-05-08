package com.gbsol.propa.common

import com.gbsol.propa.core.throwPropaException

/**
 * Created by gbaldeck on 5/7/2017.
 */
fun String.camelToDashCase(): String {
//  return this.replace(/([a-z])([A-Z])/g, '$1-$2').toLowerCase();
  return this.replace(Regex("([a-z])([A-Z])"), {
        result ->
          val (g1: String, g2: String) = result.destructured
          "$g1-$g2"
      }).toLowerCase()
}

fun String.isProperTagName(): String =
  if (this.indexOf("-") > 0)
    this.toLowerCase()
  else
    throwPropaException("The chosen element name '$this' is not in the correct custom element format.")