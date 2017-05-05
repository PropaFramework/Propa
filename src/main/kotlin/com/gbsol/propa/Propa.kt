package com.gbsol.propa

import kotlinx.html.TagConsumer
import kotlinx.html.dom.create
import org.w3c.dom.HTMLElement
import kotlin.browser.document
import kotlin.reflect.KClass

/**
 * Created by gbaldeck on 4/17/2017.
 */
interface PropaEntity

//sealed abstract class PropaEntityType {
//  operator infix fun invoke(entity: PropaEntity) = entity
//}
//
//object renderer: PropaEntityType()
//
//object component: PropaEntityType()

object the

object theWrapper {
  infix fun renderer(entity: KClass<TagConsumer<*>>) {
//    Propa.renderer = entity
  }
}


object Propa {
  infix fun has(t: the) = theWrapper

  private val components: MutableList<PropaComponent> = mutableListOf()
  private var entryComponent: PropaComponent? = null

  fun registerComponent(component: PropaComponent) = {

    components.add(component)
  }

  fun registerEntryComponent(component: PropaComponent) {
    if (entryComponent == null) {
      entryComponent = component
    } else {

    }
  }

  var renderer: PropaRenderer<*> = document.create
}


typealias PropaRenderer<T> = TagConsumer<T>