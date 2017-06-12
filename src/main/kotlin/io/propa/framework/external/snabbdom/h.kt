@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsModule("snabbdom")
@file:JsNonModule
package io.propa.framework.external.snabbdom

external fun h(sel: String): VNode = definedExternally

external fun h(sel: String, data: VNodeData): VNode = definedExternally

external fun h(sel: String, text: String): VNode = definedExternally

external fun h(sel: String, children: Array<dynamic>): VNode = definedExternally

external fun h(sel: String, data: VNodeData, text: String): VNode = definedExternally

external fun h(sel: String, data: VNodeData, children: Array<dynamic>): VNode = definedExternally
