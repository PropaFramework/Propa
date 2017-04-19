package com.gbsol.propa.element

import kotlinx.html.*
import org.w3c.dom.DocumentFragment
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLTemplateElement

/**
 * Created by gbaldeck on 4/17/2017.
 */
interface HtmlTemplateTag : MetaDataContent, FlowContent, PhrasingContent, HtmlBlockTag

@Suppress("unused")
open class TEMPLATE(initialAttributes : Map<String, String>, override val consumer : TagConsumer<*>) : HTMLTag("template", consumer, initialAttributes, null, false, false), HtmlTemplateTag {
  val content: DocumentFragment
    get(){
      val df: DocumentFragment? = null
      js("df = this.content")
      return df!!
    }
}

val TEMPLATE.asFlowContent: FlowContent
  get() = this

val TEMPLATE.asMetaDataContent: MetaDataContent
  get() = this

val TEMPLATE.asPhrasingContent: PhrasingContent
  get() = this

fun BODY.template(initalAttributes : Map<String, String> = emptyMap(), block : TEMPLATE.() -> Unit = {}) : Unit = TEMPLATE(initalAttributes, consumer).visit(block)

fun HEAD.template(initalAttributes : Map<String, String> = emptyMap(), block : TEMPLATE.() -> Unit = {}) : Unit = TEMPLATE(initalAttributes, consumer).visit(block)

fun DL.template(initalAttributes : Map<String, String> = emptyMap(), block : TEMPLATE.() -> Unit = {}) : Unit = TEMPLATE(initalAttributes, consumer).visit(block)

fun COLGROUP.template(initalAttributes : Map<String, String> = emptyMap(), block : TEMPLATE.() -> Unit = {}) : Unit {

  if (this.attributes.containsKey("span") && !this.attributes["span"].isNullOrBlank())
    throw Exception("Cannot place a <template> element inside a <colgroup> element that has 'span' as an attribute.")

  return TEMPLATE(initalAttributes, consumer).visit(block)
}


fun TagConsumer<HTMLElement>.template(initalAttributes : Map<String, String> = emptyMap(), block : TEMPLATE.() -> Unit = {}) : HTMLTemplateElement = TEMPLATE(initalAttributes, this).visitAndFinalize(this, block) as HTMLTemplateElement

internal object DocumentFragmentEncoder