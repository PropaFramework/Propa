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
annotation class Blue

object the

object theWrapper{
  infix fun renderer(entity: KClass<TagConsumer<*>>){
    Propa.renderer = entity
  }
}


object Propa{
  var renderer: KClass<out TagConsumer<*>> = document.create::class

  infix fun has(t: the) = theWrapper

}

internal object PropaRendererFactory{

  val render
      get() = Propa.renderer::class.createInstance()
}


