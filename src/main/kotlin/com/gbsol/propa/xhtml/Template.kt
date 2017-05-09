package com.gbsol.propa.xhtml

import kotlinx.html.*
import kotlinx.html.dom.JSDOMBuilder
import kotlinx.html.dom.create
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLTemplateElement
import org.w3c.dom.asList
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

    if (consumer is JSDOMBuilder)
      return finalize(consumer as TagConsumer<HTMLElement>, block) as R

    return this.visitAndFinalize(consumer, block)
  }

  fun finalize(consumer: TagConsumer<HTMLElement>, block: (TEMPLATE.() -> Unit)) : HTMLElement {
    this.visit{}
    val template = consumer.finalize() as HTMLTemplateElement
    val content = document.create.html(block = (block as HTML.() -> Unit))
    if(content !== undefined) {
      for(attribute in content.attributes.asList())
        template.setAttribute(attribute.name, attribute.value)

      for(node in content.childNodes.asList())
        template.content.append(node)
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
                                      block: TEMPLATE.() -> Unit = {}): HTMLTemplateElement =
    TEMPLATE(attributesMapOf("class", classes), this).finalizeDocFrag(this, block) as HTMLTemplateElement

fun TagConsumer<String>.template(classes : String? = null, block : TEMPLATE.() -> Unit = {}) : String =
    TEMPLATE(attributesMapOf("class", classes), this).finalizeDocFrag(this, block)
//    DIV(attributesMapOf("class", classes), this).visitAndFinalize(this, block)