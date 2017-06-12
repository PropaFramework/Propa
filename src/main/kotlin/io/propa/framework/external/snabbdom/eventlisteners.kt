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

external interface On {
  var abort: ((UIEvent) -> Unit)?
  var activate: ((UIEvent) -> Unit)?
  var beforeactivate: ((UIEvent) -> Unit)?
  var beforecopy: ((dynamic /* ClipboardEvent */) -> Unit)?
  var beforecut: ((dynamic /* ClipboardEvent */) -> Unit)?
  var beforedeactivate: ((UIEvent) -> Unit)?
  var beforepaste: ((dynamic /* ClipboardEvent */) -> Unit)?
  var blur: ((FocusEvent) -> Unit)?
  var canplay: ((Event) -> Unit)?
  var canplaythrough: ((Event) -> Unit)?
  var change: ((Event) -> Unit)?
  var click: ((MouseEvent) -> Unit)?
  var contextmenu: ((dynamic /* PointerEvent */) -> Unit)?
  var copy: ((dynamic /* ClipboardEvent */) -> Unit)?
  var cuechange: ((Event) -> Unit)?
  var cut: ((dynamic /* ClipboardEvent */) -> Unit)?
  var dblclick: ((MouseEvent) -> Unit)?
  var deactivate: ((UIEvent) -> Unit)?
  var drag: ((DragEvent) -> Unit)?
  var dragend: ((DragEvent) -> Unit)?
  var dragenter: ((DragEvent) -> Unit)?
  var dragleave: ((DragEvent) -> Unit)?
  var dragover: ((DragEvent) -> Unit)?
  var dragstart: ((DragEvent) -> Unit)?
  var drop: ((DragEvent) -> Unit)?
  var durationchange: ((Event) -> Unit)?
  var emptied: ((Event) -> Unit)?
  var ended: ((dynamic /* MediaStreamErrorEvent */) -> Unit)?
  var error: ((ErrorEvent) -> Unit)?
  var focus: ((FocusEvent) -> Unit)?
  var input: ((Event) -> Unit)?
  var invalid: ((Event) -> Unit)?
  var keydown: ((KeyboardEvent) -> Unit)?
  var keypress: ((KeyboardEvent) -> Unit)?
  var keyup: ((KeyboardEvent) -> Unit)?
  var load: ((Event) -> Unit)?
  var loadeddata: ((Event) -> Unit)?
  var loadedmetadata: ((Event) -> Unit)?
  var loadstart: ((Event) -> Unit)?
  var mousedown: ((MouseEvent) -> Unit)?
  var mouseenter: ((MouseEvent) -> Unit)?
  var mouseleave: ((MouseEvent) -> Unit)?
  var mousemove: ((MouseEvent) -> Unit)?
  var mouseout: ((MouseEvent) -> Unit)?
  var mouseover: ((MouseEvent) -> Unit)?
  var mouseup: ((MouseEvent) -> Unit)?
  var mousewheel: ((WheelEvent) -> Unit)?
  var MSContentZoom: ((UIEvent) -> Unit)?
  var MSManipulationStateChanged: ((dynamic /* MSManipulationEvent */) -> Unit)?
  var paste: ((dynamic /* ClipboardEvent */) -> Unit)?
  var pause: ((Event) -> Unit)?
  var play: ((Event) -> Unit)?
  var playing: ((Event) -> Unit)?
  var progress: ((ProgressEvent) -> Unit)?
  var ratechange: ((Event) -> Unit)?
  var reset: ((Event) -> Unit)?
  var scroll: ((UIEvent) -> Unit)?
  var seeked: ((Event) -> Unit)?
  var seeking: ((Event) -> Unit)?
  var select: ((UIEvent) -> Unit)?
  var selectstart: ((Event) -> Unit)?
  var stalled: ((Event) -> Unit)?
  var submit: ((Event) -> Unit)?
  var suspend: ((Event) -> Unit)?
  var timeupdate: ((Event) -> Unit)?
  var volumechange: ((Event) -> Unit)?
  var waiting: ((Event) -> Unit)?
  var ariarequest: ((Event) -> Unit)?
  var command: ((Event) -> Unit)?
  var gotpointercapture: ((dynamic /* PointerEvent */) -> Unit)?
  var lostpointercapture: ((dynamic /* PointerEvent */) -> Unit)?
  var MSGestureChange: ((dynamic /* MSGestureEvent */) -> Unit)?
  var MSGestureDoubleTap: ((dynamic /* MSGestureEvent */) -> Unit)?
  var MSGestureEnd: ((dynamic /* MSGestureEvent */) -> Unit)?
  var MSGestureHold: ((dynamic /* MSGestureEvent */) -> Unit)?
  var MSGestureStart: ((dynamic /* MSGestureEvent */) -> Unit)?
  var MSGestureTap: ((dynamic /* MSGestureEvent */) -> Unit)?
  var MSGotPointerCapture: ((dynamic /* MSPointerEvent */) -> Unit)?
  var MSInertiaStart: ((dynamic /* MSGestureEvent */) -> Unit)?
  var MSLostPointerCapture: ((dynamic /* MSPointerEvent */) -> Unit)?
  var MSPointerCancel: ((dynamic /* MSPointerEvent */) -> Unit)?
  var MSPointerDown: ((dynamic /* MSPointerEvent */) -> Unit)?
  var MSPointerEnter: ((dynamic /* MSPointerEvent */) -> Unit)?
  var MSPointerLeave: ((dynamic /* MSPointerEvent */) -> Unit)?
  var MSPointerMove: ((dynamic /* MSPointerEvent */) -> Unit)?
  var MSPointerOut: ((dynamic /* MSPointerEvent */) -> Unit)?
  var MSPointerOver: ((dynamic /* MSPointerEvent */) -> Unit)?
  var MSPointerUp: ((dynamic /* MSPointerEvent */) -> Unit)?
  var touchcancel: ((dynamic /* TouchEvent */) -> Unit)?
  var touchend: ((dynamic /* TouchEvent */) -> Unit)?
  var touchmove: ((dynamic /* TouchEvent */) -> Unit)?
  var touchstart: ((dynamic /* TouchEvent */) -> Unit)?
  var webkitfullscreenchange: ((Event) -> Unit)?
  var webkitfullscreenerror: ((Event) -> Unit)?
  var pointercancel: ((dynamic /* PointerEvent */) -> Unit)?
  var pointerdown: ((dynamic /* PointerEvent */) -> Unit)?
  var pointerenter: ((dynamic /* PointerEvent */) -> Unit)?
  var pointerleave: ((dynamic /* PointerEvent */) -> Unit)?
  var pointermove: ((dynamic /* PointerEvent */) -> Unit)?
  var pointerout: ((dynamic /* PointerEvent */) -> Unit)?
  var pointerover: ((dynamic /* PointerEvent */) -> Unit)?
  var pointerup: ((dynamic /* PointerEvent */) -> Unit)?
  var wheel: ((WheelEvent) -> Unit)?
}
