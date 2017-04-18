package com.gbsol.propa.element

import kotlinx.html.*
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLTemplateElement

/**
 * Created by gbaldeck on 4/17/2017.
 */
interface HtmlTemplateTag : MetaDataContent, FlowContent, PhrasingContent, HtmlBlockTag

@Suppress("unused")
open class TEMPLATE(initialAttributes : Map<String, String>, override val consumer : TagConsumer<*>) : HTMLTag("template", consumer, initialAttributes, null, false, false), HtmlTemplateTag {

  val asFlowContent: FlowContent
    get() = this

  val asMetaDataContent: MetaDataContent
    get() = this

  val asPhrasingContent: PhrasingContent
    get() = this
}

fun BODY.template(initalAttributes : Map<String, String> = emptyMap(), block : TEMPLATE.() -> Unit = {}) : HTMLTemplateElement = TEMPLATE(initalAttributes, consumer).visit(block) as HTMLTemplateElement

fun HEAD.template(initalAttributes : Map<String, String> = emptyMap(), block : TEMPLATE.() -> Unit = {}) : HTMLTemplateElement = TEMPLATE(initalAttributes, consumer).visit(block) as HTMLTemplateElement

fun DL.template(initalAttributes : Map<String, String> = emptyMap(), block : TEMPLATE.() -> Unit = {}) : HTMLTemplateElement = TEMPLATE(initalAttributes, consumer).visit(block) as HTMLTemplateElement

fun COLGROUP.template(initalAttributes : Map<String, String> = emptyMap(), block : TEMPLATE.() -> Unit = {}) : HTMLTemplateElement {

  if (!this.attributes["span"].isNullOrBlank()) throw Exception("Cannot place a <template> element inside a " +
      "<colgroup> element that has 'span' as an attribute.")

  return TEMPLATE(initalAttributes, consumer).visit(block) as HTMLTemplateElement
}


fun TagConsumer<HTMLElement>.template(initalAttributes : Map<String, String> = emptyMap(), block : TEMPLATE.() -> Unit = {}) : HTMLTemplateElement = TEMPLATE(initalAttributes, this).visitAndFinalize(this, block) as HTMLTemplateElement