@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

@JsModule("snabbdom/thunk")
@JsNonModule
external val thunkModule: dynamic = definedExternally

open class ThunkData : VNodeData()

external interface Thunk : VNode

fun thunk(sel: String, fn: Function<*>, args: Array<dynamic>): Thunk {
  return thunkModule.default(sel, fn, args)
}

fun thunk(sel: String, key: Any, fn: Function<*>, args: Array<dynamic>): Thunk {
  return thunkModule.default(sel, key, fn, args)
}