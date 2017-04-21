package com.gbsol.propa

import kotlinx.html.HTML
import kotlinx.html.dom.create
import kotlinx.html.html
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/21/2017.
 */
abstract class PropaElement {
  protected val templateElement: HTMLElement
  protected val prototype: Element

  init {
    templateElement = document.create.html(block = template())
    prototype = js("HTMLElement.prototype")
  }

  abstract protected fun template(): HTML.() -> Unit
}