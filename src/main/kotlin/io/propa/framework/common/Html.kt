package io.propa.framework.common

import org.w3c.dom.Node

/**
 * Created by gbaldeck on 6/15/2017.
 */
fun Node.removeAllChildren() {
  val _this = this
  js("while (_this.firstChild) { "+
      "  _this.removeChild(_this.firstChild);"+
      "}")
}