@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

@JsModule("snabbdom/modules/attributes")
@JsNonModule
external val attributesModule_ext: dynamic = definedExternally
val attributesModule: Module = attributesModule_ext.default

external interface Attrs

operator fun Attrs.get(key: String): dynamic = this._get(key)
operator fun Attrs.set(key: String, value: String) { this._set(key, value) }
operator fun Attrs.set(key: String, value: Number) { this._set(key, value) }
operator fun Attrs.set(key: String, value: Boolean) { this._set(key, value) }