@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

@JsModule("propsModule")
@JsNonModule
external val propsModule: Module = definedExternally

class Props{
  operator fun get(key: String): Any = js("this[key]")
  operator fun set(key: String, value: Any): Unit = js("this[key]=value")
}