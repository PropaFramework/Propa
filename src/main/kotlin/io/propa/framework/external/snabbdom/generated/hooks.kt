@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

external interface Hooks {
    var pre: (() -> Any?)? get() = definedExternally; set(value) = definedExternally
    var init: ((vNode: VNode) -> Any?)? get() = definedExternally; set(value) = definedExternally
    var create: ((emptyVNode: VNode, vNode: VNode) -> Any?)? get() = definedExternally; set(value) = definedExternally
    var insert: ((vNode: VNode) -> Any?)? get() = definedExternally; set(value) = definedExternally
    var prepatch: ((oldVNode: VNode, vNode: VNode) -> Any?)? get() = definedExternally; set(value) = definedExternally
    var update: ((oldVNode: VNode, vNode: VNode) -> Any?)? get() = definedExternally; set(value) = definedExternally
    var postpatch: ((oldVNode: VNode, vNode: VNode) -> Any?)? get() = definedExternally; set(value) = definedExternally
    var destroy: ((vNode: VNode) -> Any?)? get() = definedExternally; set(value) = definedExternally
    var remove: ((vNode: VNode, removeCallback: () -> Unit) -> Any?)? get() = definedExternally; set(value) = definedExternally
    var post: (() -> Any?)? get() = definedExternally; set(value) = definedExternally
}
