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

external interface Hooks {
    var pre: () -> Any? get() = definedExternally; set(value) = definedExternally
    var init: (vNode: VNode) -> Any? get() = definedExternally; set(value) = definedExternally
    var create: (emptyVNode: VNode, vNode: VNode) -> Any? get() = definedExternally; set(value) = definedExternally
    var insert: (vNode: VNode) -> Any? get() = definedExternally; set(value) = definedExternally
    var prepatch: (oldVNode: VNode, vNode: VNode) -> Any? get() = definedExternally; set(value) = definedExternally
    var update: (oldVNode: VNode, vNode: VNode) -> Any? get() = definedExternally; set(value) = definedExternally
    var postpatch: (oldVNode: VNode, vNode: VNode) -> Any? get() = definedExternally; set(value) = definedExternally
    var destroy: (vNode: VNode) -> Any? get() = definedExternally; set(value) = definedExternally
    var remove: (vNode: VNode, removeCallback: () -> Unit) -> Any? get() = definedExternally; set(value) = definedExternally
    var post: () -> Any? get() = definedExternally; set(value) = definedExternally
}
