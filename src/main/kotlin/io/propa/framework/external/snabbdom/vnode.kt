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

external interface VNode {
    var sel: String?
    var data: VNodeData?
    var children: Array<dynamic /* VNode | String */>?
    var elm: Node?
    var text: String?
    var key: dynamic /* String | Number */
}
open class VNodeData {
    var props: Props? = undefined
//    var attrs: Attrs? get() = definedExternally; set(value) = definedExternally
//    var `class`: Classes? get() = definedExternally; set(value) = definedExternally
//    var style: VNodeStyle? get() = definedExternally; set(value) = definedExternally
//    var dataset: Dataset? get() = definedExternally; set(value) = definedExternally
//    var on: On? get() = definedExternally; set(value) = definedExternally
//    var hero: Hero? get() = definedExternally; set(value) = definedExternally
    var attachData: AttachData? = undefined
    var hook: Hooks? = undefined
    var key: dynamic  = undefined
    var ns: String?  = undefined
    var fn: (() -> VNode)?  = undefined
    var args: Array<Any>?  = undefined
    operator fun get(key: String): Any? = js("this[key]")
    operator fun set(key: String, value: Any) = js("this[key] = value")
}
@JsModule("vnode")
external fun vnode(sel: String?, data: Any?, children: Array<dynamic /* VNode | String */>?, text: String?, elm: Element): VNode = definedExternally
@JsModule("vnode")
external fun vnode(sel: String?, data: Any?, children: Array<dynamic /* VNode | String */>?, text: String?, elm: Text): VNode = definedExternally
@JsModule("vnode")
external fun vnode(sel: String?, data: Any?, children: Array<dynamic /* VNode | String */>?, text: String?, elm: Nothing?): VNode = definedExternally
