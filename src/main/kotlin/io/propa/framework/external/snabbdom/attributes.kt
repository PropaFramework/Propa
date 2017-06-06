@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

@JsModule("snabbdom/modules/attributes")
@JsNonModule
external val attributesModule: Module = definedExternally

open class Attrs {
  operator fun get(key: String): Any? = js("this[key]")
  operator fun set(key: String, value: String) { js("this[key] = value") }
  operator fun set(key: String, value: Number) { js("this[key] = value") }
  operator fun set(key: String, value: Boolean) { js("this[key] = value") }
}