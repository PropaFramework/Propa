@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

@JsModule("snabbdom")
@JsNonModule
external object Snabbdom{
  fun init(modules: Array<Module>, domApi: DOMAPI? = definedExternally): Patch { definedExternally }
}

