package com.gbsol.propa

import kotlinx.html.BODY
import kotlinx.html.Tag

/**
 * Created by gbaldeck on 4/21/2017.
 */
interface PropaComponent {
  fun template(): PropaTemplate
}

interface PropaComponentRenderer<T: PropaComponent>

typealias PropaTemplate = BODY.() -> Unit

inline operator fun <reified T: PropaComponent> PropaComponentRenderer<T>.invoke(noinline block: T.() -> Unit = {}) {
  val component = T::class.createInstance()
  component.block()
  Propa.renderer.provideBlockToCurrentTag(component.template() as Tag.() -> Unit)
}