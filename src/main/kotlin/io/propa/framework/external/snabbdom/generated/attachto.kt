@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

import org.w3c.dom.Element
import org.w3c.dom.Node

external interface AttachData {
    operator fun get(key: String): Any?
    operator fun set(key: String, value: Any)
    operator fun get(i: Number): Any?
    operator fun set(i: Number, value: Any)
    var placeholder: Any? get() = definedExternally; set(value) = definedExternally
    var real: Node? get() = definedExternally; set(value) = definedExternally
}
@JsModule("attachTo")
external fun attachTo(target: Element, vnode: VNode): VNode = definedExternally
