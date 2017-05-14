package com.gbsol.propa.kxhtml

import org.w3c.dom.Node

/**
 * Created by gbaldeck on 5/9/2017.
 */

fun Node.removeAllChildren() {
  val _this = this
  js("while (_this.firstChild) { "+
     "  _this.removeChild(_this.firstChild);"+
     "}")
}