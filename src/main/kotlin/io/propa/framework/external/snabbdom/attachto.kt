@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

import org.w3c.dom.Element
import org.w3c.dom.Node

@JsModule("snabbdom/helpers/attachTo")
@JsNonModule
external val attachTo: dynamic = definedExternally
fun attachTo(target: Element, vnode: VNode): VNode = attachTo.default(target, vnode)

open class AttachData {
    operator fun get(key: String): Any? = js("this[key]")
    operator fun set(key: String, value: Any) { js("this[key] = value") }
    operator fun get(i: Number): Any? = js("this[key]")
    operator fun set(i: Number, value: Any) { js("this[key] = value") }
    var placeholder: Any? = undefined
    var real: Node? = undefined
}