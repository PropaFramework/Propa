package com.gbsol.propa.element

import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.stream.HTMLStreamBuilder
import kotlinx.html.stream.createHTML
import org.w3c.dom.*
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/17/2017.
 */

@Suppress("unused")
open class TEMPLATE(initialAttributes: Map<String, String>, override val consumer: TagConsumer<*>) : HTMLTag("template", consumer, initialAttributes, null, false, false), FlowMetaDataPhrasingContent {

  inline fun <reified R> generateDocFragContent(consumer: TagConsumer<R>, block: Any) {

    console.log("got here")
    println("got here")
    println("string is r: "+(String is R))
    if(String is R)
      (this as Tag).visit(block as (Tag.() -> Unit))
    else
      finalize(consumer as TagConsumer<HTMLElement>, block as (TagConsumer<HTMLElement>.() -> HTMLElement))
  }

  inline fun <reified R> finalizeDocFrag(consumer: TagConsumer<R>, block: Any?) : R {
    if (this.consumer !== consumer) {
      throw IllegalArgumentException("Wrong exception")
    }
    val tmp = consumer is HTMLStreamBuilder
    println("$tmp")
    println("consumer's class: ${consumer::class.simpleName}")
    println("R's class: ${R::class.simpleName}")
    println("${String::class.simpleName}")

    if(block !== null) {
      if (String is R)
        return (this as Tag).visitAndFinalize(consumer, block as (Tag.() -> Unit))
      else
        return finalize(consumer as TagConsumer<HTMLElement>, block as (TagConsumer<HTMLElement>.() -> HTMLElement)) as R
    }

    return consumer.finalize()
  }

  fun finalize(consumer: TagConsumer<HTMLElement>, block: (TagConsumer<HTMLElement>.() -> HTMLElement)) : HTMLElement {
    this.visit{}
    val template = consumer.finalize() as HTMLTemplateElement
    val content = document.create.block()
    template.content.appendChild(content);
    return template
  }
}

val TEMPLATE.asFlowContent: FlowContent
  get() = this

val TEMPLATE.asMetaDataContent: MetaDataContent
  get() = this

val TEMPLATE.asPhrasingContent: PhrasingContent
  get() = this

fun FlowMetaDataPhrasingContent.template(classes : String? = null, block: TEMPLATE.() -> Unit = {}): Unit =
    TEMPLATE(attributesMapOf("class", classes), consumer).generateDocFragContent(consumer, block)

fun COLGROUP.template(classes : String? = null, block: TEMPLATE.() -> Unit = {}): Unit {

  if (this.attributes.containsKey("span") && !this.attributes["span"].isNullOrBlank())
    throw Exception("Cannot place a <template> element inside a <colgroup> element that has 'span' as an attribute.")

  return TEMPLATE(attributesMapOf("class", classes), consumer).generateDocFragContent(consumer, block)
}


fun TagConsumer<HTMLElement>.template(classes : String? = null,
                                      block: (TagConsumer<HTMLElement>.() -> HTMLElement)? = null): HTMLTemplateElement =
    TEMPLATE(attributesMapOf("class", classes), this).finalizeDocFrag(this, block) as HTMLTemplateElement

fun TagConsumer<String>.template(classes : String? = null, block : TEMPLATE.() -> Unit = {}) : String =
    TEMPLATE(attributesMapOf("class", classes), this).finalizeDocFrag(this, block)
//    DIV(attributesMapOf("class", classes), this).visitAndFinalize(this, block)