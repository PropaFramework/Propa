package com.gbsol.propa

import kotlinx.html.BODY
import kotlinx.html.HTMLTag
import org.w3c.dom.HTMLElement

/**
 * Created by gbaldeck on 4/21/2017.
 */
interface PropaComponent {
  companion object
  fun template(): PropaTemplate
  fun render() = "Im good"

}

interface PropaComponentRenderer<T>

//interface PropaTemplate: Tag{
//  operator fun invoke()
//}

internal inline operator fun <reified T> PropaComponentRenderer<T>.invoke(body: PropaTemplate) {
//  Propa.renderer.
}

typealias PropaTemplate = BODY.() -> Unit