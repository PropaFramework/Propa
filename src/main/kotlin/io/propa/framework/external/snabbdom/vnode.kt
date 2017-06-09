@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.Text

@JsModule("snabbdom/vnode")
@JsNonModule
external val vNodeModule: dynamic = definedExternally

fun vnode(sel: String? = undefined, data: Any? = undefined, children: Array<VNode>? = undefined,
          text: String? = undefined, elm: Element? = undefined): VNode{
  return vNodeModule.default(sel, data, children, text, elm)
}

fun vnode(sel: String? = undefined, data: Any? = undefined, children: Array<String>? = undefined,
          text: String? = undefined, elm: Element? = undefined): VNode{
  return vNodeModule.default(sel, data, children, text, elm)
}

fun vnode(sel: String? = undefined, data: Any? = undefined, children: Array<VNode>? = undefined,
          text: String? = undefined, elm: Text? = undefined): VNode{
  return vNodeModule.default(sel, data, children, text, elm)
}

fun vnode(sel: String? = undefined, data: Any? = undefined, children: Array<String>? = undefined,
          text: String? = undefined, elm: Text? = undefined): VNode{
  return vNodeModule.default(sel, data, children, text, elm)
}

external interface VNode {
    var sel: String?
    var data: dynamic /* VNodeData? */
    var children: Array<dynamic /* VNode | String */>?
    var elm: Node?
    var text: String?
    var key: dynamic /* String | Number */
}
open class VNodeData {
    var props: Props? = undefined
    var attrs: Attrs? = undefined
    var `class`: Classes? = undefined
    var style: VNodeStyle? = undefined
    var dataset: Dataset? = undefined
    var on: On? = undefined
    var hero: Hero? = undefined
    var attachData: AttachData? = undefined
    var hook: Hooks? = undefined
    var key: dynamic  = undefined
    var ns: String?  = undefined
    var fn: (() -> VNode)?  = undefined
    var args: Array<Any>?  = undefined
}

operator fun VNodeData.get(key: String): dynamic = this._get(key)
operator fun VNodeData.set(key: String, value: dynamic) = this._set(key, value)


