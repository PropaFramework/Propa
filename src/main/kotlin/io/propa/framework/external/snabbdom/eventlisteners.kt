@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

import org.w3c.dom.DragEvent
import org.w3c.dom.ErrorEvent
import org.w3c.dom.events.*
import org.w3c.xhr.ProgressEvent

@JsModule("snabbdom/modules/eventlisteners")
@JsNonModule
external val eventListenersModule_ext: dynamic = definedExternally
val eventListenersModule: Module = eventListenersModule_ext.default

operator fun On.get(key: String): (dynamic) -> Unit = this._get(key)
operator fun On.set(key: String, value: (dynamic) -> Unit) { this._set(key, value) }

open class On {
  var abort: ((UIEvent) -> Unit)? = undefined
  var activate: ((UIEvent) -> Unit)? = undefined
  var beforeactivate: ((UIEvent) -> Unit)? = undefined
  var beforecopy: ((dynamic /* ClipboardEvent */) -> Unit)? = undefined
  var beforecut: ((dynamic /* ClipboardEvent */) -> Unit)? = undefined
  var beforedeactivate: ((UIEvent) -> Unit)? = undefined
  var beforepaste: ((dynamic /* ClipboardEvent */) -> Unit)? = undefined
  var blur: ((FocusEvent) -> Unit)? = undefined
  var canplay: ((Event) -> Unit)? = undefined
  var canplaythrough: ((Event) -> Unit)? = undefined
  var change: ((Event) -> Unit)? = undefined
  var click: ((MouseEvent) -> Unit)? = undefined
  var contextmenu: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var copy: ((dynamic /* ClipboardEvent */) -> Unit)? = undefined
  var cuechange: ((Event) -> Unit)? = undefined
  var cut: ((dynamic /* ClipboardEvent */) -> Unit)? = undefined
  var dblclick: ((MouseEvent) -> Unit)? = undefined
  var deactivate: ((UIEvent) -> Unit)? = undefined
  var drag: ((DragEvent) -> Unit)? = undefined
  var dragend: ((DragEvent) -> Unit)? = undefined
  var dragenter: ((DragEvent) -> Unit)? = undefined
  var dragleave: ((DragEvent) -> Unit)? = undefined
  var dragover: ((DragEvent) -> Unit)? = undefined
  var dragstart: ((DragEvent) -> Unit)? = undefined
  var drop: ((DragEvent) -> Unit)? = undefined
  var durationchange: ((Event) -> Unit)? = undefined
  var emptied: ((Event) -> Unit)? = undefined
  var ended: ((dynamic /* MediaStreamErrorEvent */) -> Unit)? = undefined
  var error: ((ErrorEvent) -> Unit)? = undefined
  var focus: ((FocusEvent) -> Unit)? = undefined
  var input: ((Event) -> Unit)? = undefined
  var invalid: ((Event) -> Unit)? = undefined
  var keydown: ((KeyboardEvent) -> Unit)? = undefined
  var keypress: ((KeyboardEvent) -> Unit)? = undefined
  var keyup: ((KeyboardEvent) -> Unit)? = undefined
  var load: ((Event) -> Unit)? = undefined
  var loadeddata: ((Event) -> Unit)? = undefined
  var loadedmetadata: ((Event) -> Unit)? = undefined
  var loadstart: ((Event) -> Unit)? = undefined
  var mousedown: ((MouseEvent) -> Unit)? = undefined
  var mouseenter: ((MouseEvent) -> Unit)? = undefined
  var mouseleave: ((MouseEvent) -> Unit)? = undefined
  var mousemove: ((MouseEvent) -> Unit)? = undefined
  var mouseout: ((MouseEvent) -> Unit)? = undefined
  var mouseover: ((MouseEvent) -> Unit)? = undefined
  var mouseup: ((MouseEvent) -> Unit)? = undefined
  var mousewheel: ((WheelEvent) -> Unit)? = undefined
  var MSContentZoom: ((UIEvent) -> Unit)? = undefined
  var MSManipulationStateChanged: ((dynamic /* MSManipulationEvent */) -> Unit)? = undefined
  var paste: ((dynamic /* ClipboardEvent */) -> Unit)? = undefined
  var pause: ((Event) -> Unit)? = undefined
  var play: ((Event) -> Unit)? = undefined
  var playing: ((Event) -> Unit)? = undefined
  var progress: ((ProgressEvent) -> Unit)? = undefined
  var ratechange: ((Event) -> Unit)? = undefined
  var reset: ((Event) -> Unit)? = undefined
  var scroll: ((UIEvent) -> Unit)? = undefined
  var seeked: ((Event) -> Unit)? = undefined
  var seeking: ((Event) -> Unit)? = undefined
  var select: ((UIEvent) -> Unit)? = undefined
  var selectstart: ((Event) -> Unit)? = undefined
  var stalled: ((Event) -> Unit)? = undefined
  var submit: ((Event) -> Unit)? = undefined
  var suspend: ((Event) -> Unit)? = undefined
  var timeupdate: ((Event) -> Unit)? = undefined
  var volumechange: ((Event) -> Unit)? = undefined
  var waiting: ((Event) -> Unit)? = undefined
  var ariarequest: ((Event) -> Unit)? = undefined
  var command: ((Event) -> Unit)? = undefined
  var gotpointercapture: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var lostpointercapture: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var MSGestureChange: ((dynamic /* MSGestureEvent */) -> Unit)? = undefined
  var MSGestureDoubleTap: ((dynamic /* MSGestureEvent */) -> Unit)? = undefined
  var MSGestureEnd: ((dynamic /* MSGestureEvent */) -> Unit)? = undefined
  var MSGestureHold: ((dynamic /* MSGestureEvent */) -> Unit)? = undefined
  var MSGestureStart: ((dynamic /* MSGestureEvent */) -> Unit)? = undefined
  var MSGestureTap: ((dynamic /* MSGestureEvent */) -> Unit)? = undefined
  var MSGotPointerCapture: ((dynamic /* MSPointerEvent */) -> Unit)? = undefined
  var MSInertiaStart: ((dynamic /* MSGestureEvent */) -> Unit)? = undefined
  var MSLostPointerCapture: ((dynamic /* MSPointerEvent */) -> Unit)? = undefined
  var MSPointerCancel: ((dynamic /* MSPointerEvent */) -> Unit)? = undefined
  var MSPointerDown: ((dynamic /* MSPointerEvent */) -> Unit)? = undefined
  var MSPointerEnter: ((dynamic /* MSPointerEvent */) -> Unit)? = undefined
  var MSPointerLeave: ((dynamic /* MSPointerEvent */) -> Unit)? = undefined
  var MSPointerMove: ((dynamic /* MSPointerEvent */) -> Unit)? = undefined
  var MSPointerOut: ((dynamic /* MSPointerEvent */) -> Unit)? = undefined
  var MSPointerOver: ((dynamic /* MSPointerEvent */) -> Unit)? = undefined
  var MSPointerUp: ((dynamic /* MSPointerEvent */) -> Unit)? = undefined
  var touchcancel: ((dynamic /* TouchEvent */) -> Unit)? = undefined
  var touchend: ((dynamic /* TouchEvent */) -> Unit)? = undefined
  var touchmove: ((dynamic /* TouchEvent */) -> Unit)? = undefined
  var touchstart: ((dynamic /* TouchEvent */) -> Unit)? = undefined
  var webkitfullscreenchange: ((Event) -> Unit)? = undefined
  var webkitfullscreenerror: ((Event) -> Unit)? = undefined
  var pointercancel: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var pointerdown: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var pointerenter: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var pointerleave: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var pointermove: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var pointerout: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var pointerover: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var pointerup: ((dynamic /* PointerEvent */) -> Unit)? = undefined
  var wheel: ((WheelEvent) -> Unit)? = undefined
}
