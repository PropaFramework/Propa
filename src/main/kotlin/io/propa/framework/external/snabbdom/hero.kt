@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

@JsModule("snabbdom/modules/hero")
@JsNonModule
external val heroModule_ext: dynamic = definedExternally
val heroModule: Module = heroModule_ext.default

external interface Hero {
    var id: String?
}

