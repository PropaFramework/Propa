package io.propa.framework.snabbdom

/**
 * Created by gbaldeck on 6/1/2017.
 */
@JsModule("snabbdom")
@JsNonModule
external object Snabbdom{
  fun init(modules: dynamic, domApi: dynamic): (oldNode: dynamic, newNode: dynamic) -> Unit { definedExternally }
}

@JsModule("snabbdom/h")
@JsNonModule
external fun h(a:dynamic, b:dynamic, c:dynamic) { definedExternally }