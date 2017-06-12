@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.Text

@JsModule("snabbdom/vnode")
@JsNonModule
external val vNodeModule: dynamic = definedExternally

fun vnode(sel: String?, data: Any?, children: Array<VNode>?,
          text: String?, elm: Element?): VNode{
  return vNodeModule.default(sel, data, children, text, elm)
}

fun vnode(sel: String?, data: Any?, children: Array<String>?,
          text: String?, elm: Element?): VNode{
  return vNodeModule.default(sel, data, children, text, elm)
}

fun vnode(sel: String?, data: Any?, children: Array<VNode>?,
          text: String?, elm: Text?): VNode{
  return vNodeModule.default(sel, data, children, text, elm)
}

fun vnode(sel: String?, data: Any?, children: Array<String>?,
          text: String?, elm: Text?): VNode{
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
external interface VNodeData {
    var props: Props?
    var attrs: Attrs?
    var `class`: Classes?
    var style: VNodeStyle?
    var dataset: Dataset?
    var on: On?
    var hero: Hero?
    var attachData: AttachData?
    var hook: Hooks?
    var key: dynamic 
    var ns: String? 
    var fn: (() -> VNode)? 
    var args: Array<dynamic>? 
}

operator fun VNodeData.get(key: String): dynamic = this._get(key)
operator fun VNodeData.set(key: String, value: dynamic) = this._set(key, value)


