package com.gbsol.propa.xhtml

import kotlinx.html.Tag
import org.w3c.dom.Node

/**
 * Created by gbaldeck on 5/9/2017.
 */

fun Tag.setAttribute(name: String, value: String) = attributes.put(name, value)

fun Node.removeAllChildren() {
  val _this = this
  js("while (_this.firstChild) { "+
     "  _this.removeChild(_this.firstChild);"+
     "}")
}