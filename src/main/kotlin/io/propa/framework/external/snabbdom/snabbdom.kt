@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsModule("snabbdom")
@file:JsNonModule
package io.propa.framework.external.snabbdom

external fun init(modules: Array<Module>, domApi: DOMAPI? = definedExternally): Patch = definedExternally

