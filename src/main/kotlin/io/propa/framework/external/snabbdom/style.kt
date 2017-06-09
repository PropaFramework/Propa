@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

@JsModule("snabbdom/modules/style")
@JsNonModule
external val styleModule: Module = definedExternally

open class VNodeStyle{
  var delayed: Delayed? = undefined
  var remove: Remove? = undefined

  open class Delayed
  open class Remove
}

operator fun VNodeStyle.get(key: String): String = this._get(key)
operator fun VNodeStyle.set(key: String, value: String) = this._set(key, value)

operator fun VNodeStyle.Delayed.get(key: String): String = this._get(key)
operator fun VNodeStyle.Delayed.set(key: String, value: String) = this._set(key, value)

operator fun VNodeStyle.Remove.get(key: String): String = this._get(key)
operator fun VNodeStyle.Remove.set(key: String, value: String) = this._set(key, value)

