@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

@JsModule("snabbdom/modules/class")
@JsNonModule
external val classModule: Module = definedExternally

open class Classes

operator fun Classes.get(key: String): Boolean = this._get(key)
operator fun Classes.set(key: String, value: Boolean) { this._set(key, value) }