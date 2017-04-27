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
@Blue
abstract class PropaElement: PropaEntity {
  protected val templateElement: HTMLElement
  protected val prototype: HTMLElement

  init {
    templateElement = document.create.html(block = template())
    prototype = js("Object.create(HTMLElement.prototype)")
  }

  abstract protected fun template(): HTML.() -> Unit
}

class MyElement : PropaElement(){
  override fun template(): HTML.() -> Unit {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}