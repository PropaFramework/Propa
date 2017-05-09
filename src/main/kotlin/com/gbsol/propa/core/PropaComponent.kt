package com.gbsol.propa.core

import com.gbsol.propa.Propa
import com.gbsol.propa.common.camelToDashCase
import com.gbsol.propa.common.createInstance
import com.gbsol.propa.common.isProperTagName
import kotlinx.html.HtmlBlockTag
import org.w3c.dom.Element
import org.w3c.dom.get
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/21/2017.
 */
abstract class PropaComponent {
  val propaId: String = generatePropaId()

  var tagName: String = "" //the get() of this should only be used in getComponentTagName()
  protected set

  var classes: String? = null
  protected set

  var style: String? = null
  protected set

  val extraAttributes: Map<String, String> = mutableMapOf()

  val element: Element
    get() {
      var target: Element? = document.getElementsByClassName(propaId)[0]

      return target ?: throwPropaException("Element '${getComponentTagName()}' with propa-id '$propaId' was not found.")
    }

  private fun generatePropaId(): String {
    var text: String

    do{
      text = "propa-"
      val possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"

      for (i in 0..8)
        js("text += possible.charAt(Math.floor(Math.random() * possible.length))")

    }while(Propa.componentMap.containsKey(text))

    return text;
  }

  abstract fun template(): PropaTemplate
}

fun PropaComponent.getComponentTagName(): String =
    if (this.tagName.trim() == "")
      this::class.simpleName!!.camelToDashCase()
    else
      this.tagName.isProperTagName()


typealias PropaTemplate = HtmlBlockTag.() -> Unit

interface PropaComponentRenderer<T: PropaComponent>

inline operator fun <reified T: PropaComponent> PropaComponentRenderer<T>.invoke(noinline block: T.() -> Unit = {}) {
  val component = this.createInstance()
  component.block()
  Propa.renderer.insertPropaComponent(component)
}

inline fun <reified T: PropaComponent> PropaComponentRenderer<T>.createInstance(): T {
  val component = T::class.createInstance()
  Propa.addComponent(component)
  return component
}

fun PropaComponent.getAttributes(): Map<String, String> {
  val attributes = linkedMapOf<String, String>()

  this.classes?.let { attributes["class"] = it.trim()+" "+propaId } ?: attributes.put("class", propaId)
  this.style?.let { attributes["style"] = it.trim() }

  this.extraAttributes.forEach { (key, value) -> attributes[key.trim()] = value.trim() }

  return attributes
}