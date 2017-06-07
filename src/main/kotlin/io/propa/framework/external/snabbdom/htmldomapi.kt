@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

import org.w3c.dom.*

@JsModule("snabbdom/htmldomapi")
@JsNonModule
external val htmlDomApiModule:dynamic = definedExternally
val htmlDomApi: DOMAPI = htmlDomApiModule.default

external interface DOMAPI {
    fun createElement(tagName: dynamic): HTMLElement
    fun createElementNS(namespaceURI: String, qualifiedName: String): Element
    fun createTextNode(text: String): Text
    fun createComment(text: String): Comment
    fun insertBefore(parentNode: Node, newNode: Node, referenceNode: Node?): Unit
    fun removeChild(node: Node, child: Node): Unit
    fun appendChild(node: Node, child: Node): Unit
    fun parentNode(node: Node): Node
    fun nextSibling(node: Node): Node
    fun tagName(elm: Element): String
    fun setTextContent(node: Node, text: String?): Unit
    fun getTextContent(node: Node): String?
    fun isElement(node: Node): Boolean
    fun isText(node: Node): Boolean
    fun isComment(node: Node): Boolean
}