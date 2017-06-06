@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

open class Hooks {
    lateinit var pre: PreHook
    lateinit var init: InitHook
    lateinit var create: CreateHook
    lateinit var insert: InsertHook
    lateinit var prepatch: PrePatchHook
    lateinit var update: UpdateHook
    lateinit var postpatch: PostPatchHook
    lateinit var destroy: DestroyHook
    lateinit var remove: RemoveHook
    lateinit var post: PostHook
}

typealias PreHook = () -> Any?
typealias InitHook = (vNode: VNode) -> Any?
typealias CreateHook = (emptyVNode: VNode, vNode: VNode) -> Any?
typealias InsertHook = (vNode: VNode) -> Any?
typealias PrePatchHook = (oldVNode: VNode, vNode: VNode) -> Any?
typealias UpdateHook = (oldVNode: VNode, vNode: VNode) -> Any?
typealias PostPatchHook = (oldVNode: VNode, vNode: VNode) -> Any?
typealias DestroyHook = (vNode: VNode) -> Any?
typealias RemoveHook = (vNode: VNode, removeCallback: () -> Unit) -> Any?
typealias PostHook = () -> Any?
