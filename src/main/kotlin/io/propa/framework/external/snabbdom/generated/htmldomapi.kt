@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external interface DOMAPI {
    var createElement: (tagName: Any) -> HTMLElement
    var createElementNS: (namespaceURI: String, qualifiedName: String) -> Element
    var createTextNode: (text: String) -> Text
    var createComment: (text: String) -> Comment
    var insertBefore: (parentNode: Node, newNode: Node, referenceNode: Node?) -> Unit
    var removeChild: (node: Node, child: Node) -> Unit
    var appendChild: (node: Node, child: Node) -> Unit
    var parentNode: (node: Node) -> Node
    var nextSibling: (node: Node) -> Node
    var tagName: (elm: Element) -> String
    var setTextContent: (node: Node, text: String?) -> Unit
    var getTextContent: (node: Node) -> String?
    var isElement: (node: Node) -> Boolean
    var isText: (node: Node) -> Boolean
    var isComment: (node: Node) -> Boolean
}
@JsModule("htmlDomApi")
external val htmlDomApi: DOMAPI = definedExternally
