package com.gbsol.propa.core

import com.gbsol.propa.Propa
import com.gbsol.propa.common.camelToDashCase
import com.gbsol.propa.common.createInstance
import com.gbsol.propa.common.isProperTagName
import kotlinx.html.HtmlBlockTag

/**
 * Created by gbaldeck on 4/21/2017.
 */
abstract class PropaComponent {
  var tagName: String = ""
  protected set

  abstract fun template(): PropaTemplate
}

fun PropaComponent.getComponentTagName(): String =
    if (this.tagName.trim() == "")
      this::class.simpleName!!.camelToDashCase() //todo: If class name is one word or has not capital letters it wont be valid
    else
      this.tagName.isProperTagName()


typealias PropaTemplate = HtmlBlockTag.() -> Unit

interface PropaComponentRenderer<T: PropaComponent>

inline operator fun <reified T: PropaComponent> PropaComponentRenderer<T>.invoke(noinline block: T.() -> Unit = {}) {
  val component = this.createInstance()
  component.block()
  Propa.renderer.insertPropaComponent(component)
}

inline fun <reified T: PropaComponent> PropaComponentRenderer<T>.createInstance() =
    T::class.createInstance()