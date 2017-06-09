@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

import org.w3c.dom.Node

@JsModule("snabbdom/tovnode")
@JsNonModule
external val toVNodeModule: dynamic = definedExternally

fun toVNode(node: Node, domApi: DOMAPI? = undefined): VNode = toVNodeModule.default(node, domApi)
