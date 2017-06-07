@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

@JsModule("snabbdom/modules/props")
@JsNonModule
external val propsModule: Module = definedExternally

open class Props{
  operator fun get(key: String): dynamic = js("this[key]")
  operator fun set(key: String, value: dynamic): Unit = js("this[key]=value")
}