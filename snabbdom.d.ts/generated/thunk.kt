@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external interface ThunkData : VNodeData {
    var fn: () -> VNode
    var args: Array<Any>
}
external interface Thunk : VNode {
    var data: ThunkData
}
external interface ThunkFn {
    @nativeInvoke
    operator fun invoke(sel: String, fn: Function<*>, args: Array<Any>): Thunk
    @nativeInvoke
    operator fun invoke(sel: String, key: Any, fn: Function<*>, args: Array<Any>): Thunk
}
@JsModule("thunk")
external val thunk: ThunkFn = definedExternally
