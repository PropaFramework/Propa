@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

import org.w3c.dom.Element
import org.w3c.dom.Node

@JsModule("snabbdom/helpers/attachTo")
@JsNonModule
external val attachTo: dynamic = definedExternally
fun attachTo(target: Element, vnode: VNode): VNode = attachTo.default(target, vnode)

external interface AttachData {
  var placeholder: dynamic
  var real: Node?
}

operator fun AttachData.get(key: String): dynamic = this._get(key)
operator fun AttachData.set(key: String, value: dynamic) { this._set(key, value) }
operator fun AttachData.get(key: Number): dynamic = this._get(key)
operator fun AttachData.set(key: Number, value: dynamic) { this._set(key, value) }