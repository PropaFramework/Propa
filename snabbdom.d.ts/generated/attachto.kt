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

external interface AttachData {
    @nativeGetter
    operator fun get(key: String): Any?
    @nativeSetter
    operator fun set(key: String, value: Any)
    @nativeGetter
    operator fun get(i: Number): Any?
    @nativeSetter
    operator fun set(i: Number, value: Any)
    var placeholder: Any? get() = definedExternally; set(value) = definedExternally
    var real: Node? get() = definedExternally; set(value) = definedExternally
}
@JsModule("attachTo")
external fun attachTo(target: Element, vnode: VNode): VNode = definedExternally
