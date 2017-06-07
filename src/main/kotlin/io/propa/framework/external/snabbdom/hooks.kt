@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

open class Hooks {
    var pre: PreHook? = undefined
    var init: InitHook? = undefined
    var create: CreateHook? = undefined
    var insert: InsertHook? = undefined
    var prepatch: PrePatchHook? = undefined
    var update: UpdateHook? = undefined
    var postpatch: PostPatchHook? = undefined
    var destroy: DestroyHook? = undefined
    var remove: RemoveHook? = undefined
    var post: PostHook? = undefined
}

typealias PreHook = () -> dynamic
typealias InitHook = (vNode: VNode) -> dynamic
typealias CreateHook = (emptyVNode: VNode, vNode: VNode) -> dynamic
typealias InsertHook = (vNode: VNode) -> dynamic
typealias PrePatchHook = (oldVNode: VNode, vNode: VNode) -> dynamic
typealias UpdateHook = (oldVNode: VNode, vNode: VNode) -> dynamic
typealias PostPatchHook = (oldVNode: VNode, vNode: VNode) -> dynamic
typealias DestroyHook = (vNode: VNode) -> dynamic
typealias RemoveHook = (vNode: VNode, removeCallback: () -> Unit) -> dynamic
typealias PostHook = () -> dynamic
