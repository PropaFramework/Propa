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
external object h_external{
  fun default(sel: dynamic, b:dynamic, c:dynamic): dynamic = definedExternally
}

fun h(sel: String, b:dynamic = undefined, c:dynamic = undefined) = h_external.default(sel, b, c)

@JsModule("snabbdom/modules/class")
@JsNonModule
external object SnabbClass_external {
  val default:dynamic = definedExternally
}

val SnabbClass = SnabbClass_external.default

@JsModule("snabbdom/modules/props")
@JsNonModule
external object SnabbProps_external {
  val default:dynamic = definedExternally
}

val SnabbProps = SnabbProps_external.default

@JsModule("snabbdom/modules/style")
@JsNonModule
external object SnabbStyle_external {
  val default:dynamic = definedExternally
}

val SnabbStyle = SnabbStyle_external.default

@JsModule("snabbdom/modules/eventlisteners")
@JsNonModule
external object SnabbEventListeners_external {
  val default:dynamic = definedExternally
}

val SnabbEventListeners = SnabbEventListeners_external.default