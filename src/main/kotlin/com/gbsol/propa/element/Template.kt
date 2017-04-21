package com.gbsol.propa.element

import kotlinx.html.*
import kotlinx.html.dom.JSDOMBuilder
import kotlinx.html.dom.create
import kotlinx.html.stream.HTMLStreamBuilder
import kotlinx.html.stream.createHTML
import org.w3c.dom.*
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/17/2017.
 */

@Suppress("unused")
open class TEMPLATE(initialAttributes: Map<String, String>, override var consumer: TagConsumer<*>) : HTMLTag("template", consumer, initialAttributes, null, false, false), FlowMetaDataPhrasingContent {

  fun <R> generateDocFragContent(consumer: TagConsumer<R>, block: TEMPLATE.() -> Unit) {
    if(consumer is JSDOMBuilder)
      finalize(consumer as TagConsumer<HTMLElement>, block)
    else
      this.visit(block)
  }

  fun <R> finalizeDocFrag(consumer: TagConsumer<R>, block: TEMPLATE.() -> Unit) : R {
    if (this.consumer !== consumer) {
      throw IllegalArgumentException("Wrong exception")
    }

    if(block !== null) {
      if (consumer is JSDOMBuilder)
        return finalize(consumer as TagConsumer<HTMLElement>, block) as R
      else
        return this.visitAndFinalize(consumer, block)
    }

    this.visit{}
    return consumer.finalize()
  }

  fun finalize(consumer: TagConsumer<HTMLElement>, block: (TEMPLATE.() -> Unit)) : HTMLElement {
    this.visit{}
    val template = consumer.finalize() as HTMLTemplateElement
    console.log("here")
    val content = document.create.html(block = (block as HTML.() -> Unit)) as HTMLElement

    console.log("content: ", content)
    if(content !== undefined) {
      console.log("nodes: "+content.childNodes)
      console.log("nodes length: "+content.childNodes.length)
      content.childNodes.asList().forEach {
        template.content.append(it)
      }
    }

    return template
  }
}

val TEMPLATE.asFlowContent: FlowContent
  get() = this

val TEMPLATE.asMetaDataContent: MetaDataContent
  get() = this

val TEMPLATE.asPhrasingContent: PhrasingContent
  get() = this

fun HTMLTag.template(classes : String? = null, block: TEMPLATE.() -> Unit = {}): Unit =
    TEMPLATE(attributesMapOf("class", classes), consumer).generateDocFragContent(consumer, block)

fun COLGROUP.template(classes : String? = null, block: TEMPLATE.() -> Unit = {}): Unit {

  if (this.attributes.containsKey("span") && !this.attributes["span"].isNullOrBlank())
    throw Exception("Cannot place a <template> element inside a <colgroup> element that has 'span' as an attribute.")

  return TEMPLATE(attributesMapOf("class", classes), consumer).generateDocFragContent(consumer, block)
}


fun TagConsumer<HTMLElement>.template(classes : String? = null,
                                      block: TEMPLATE.() -> Unit): HTMLTemplateElement =
    TEMPLATE(attributesMapOf("class", classes), this).finalizeDocFrag(this, block) as HTMLTemplateElement

fun TagConsumer<String>.template(classes : String? = null, block : TEMPLATE.() -> Unit = {}) : String =
    TEMPLATE(attributesMapOf("class", classes), this).finalizeDocFrag(this, block)
//    DIV(attributesMapOf("class", classes), this).visitAndFinalize(this, block)