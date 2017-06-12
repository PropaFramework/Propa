@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

@JsModule("snabbdom/modules/dataset")
@JsNonModule
external val datasetModule_ext: dynamic = definedExternally
val datasetModule: Module =  datasetModule_ext.default

external interface Dataset

operator fun Dataset.get(key: String): String = this._get(key)
operator fun Dataset.set(key: String, value: String) { this._set(key, value) }