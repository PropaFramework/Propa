@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package io.propa.framework.external.snabbdom

import org.w3c.dom.DragEvent
import org.w3c.dom.ErrorEvent
import org.w3c.dom.events.*
import org.w3c.xhr.ProgressEvent

@JsModule("snabbdom/modules/eventlisteners")
@JsNonModule
external val eventListenersModule: Module = definedExternally

open class On {
  operator fun get(key: String): (Event) -> Unit = js("this[key]")
  operator fun <T: Event> set(key: String, value: (T) -> Unit) { js("this[key] = value") }
  lateinit var abort: (UIEvent) -> Unit
  lateinit var activate: (UIEvent) -> Unit
  lateinit var beforeactivate: (UIEvent) -> Unit
  lateinit var beforecopy: (Event) -> Unit //ClipboardEvent
  lateinit var beforecut: (Event) -> Unit //ClipboardEvent
  lateinit var beforedeactivate: (UIEvent) -> Unit
  lateinit var beforepaste: (Event) -> Unit //ClipboardEvent
  lateinit var blur: (FocusEvent) -> Unit
  lateinit var canplay: (Event) -> Unit
  lateinit var canplaythrough: (Event) -> Unit
  lateinit var change: (Event) -> Unit
  lateinit var click: (MouseEvent) -> Unit
  lateinit var contextmenu: (Event) -> Unit //PointerEvent
  lateinit var copy: (Event) -> Unit //ClipboardEvent
  lateinit var cuechange: (Event) -> Unit
  lateinit var cut: (Event) -> Unit //ClipboardEvent
  lateinit var dblclick: (MouseEvent) -> Unit
  lateinit var deactivate: (UIEvent) -> Unit
  lateinit var drag: (DragEvent) -> Unit
  lateinit var dragend: (DragEvent) -> Unit
  lateinit var dragenter: (DragEvent) -> Unit
  lateinit var dragleave: (DragEvent) -> Unit
  lateinit var dragover: (DragEvent) -> Unit
  lateinit var dragstart: (DragEvent) -> Unit
  lateinit var drop: (DragEvent) -> Unit
  lateinit var durationchange: (Event) -> Unit
  lateinit var emptied: (Event) -> Unit
  lateinit var ended: (Event) -> Unit //MediaStreamErrorEvent
  lateinit var error: (ErrorEvent) -> Unit
  lateinit var focus: (FocusEvent) -> Unit
  lateinit var input: (Event) -> Unit
  lateinit var invalid: (Event) -> Unit
  lateinit var keydown: (KeyboardEvent) -> Unit
  lateinit var keypress: (KeyboardEvent) -> Unit
  lateinit var keyup: (KeyboardEvent) -> Unit
  lateinit var load: (Event) -> Unit
  lateinit var loadeddata: (Event) -> Unit
  lateinit var loadedmetadata: (Event) -> Unit
  lateinit var loadstart: (Event) -> Unit
  lateinit var mousedown: (MouseEvent) -> Unit
  lateinit var mouseenter: (MouseEvent) -> Unit
  lateinit var mouseleave: (MouseEvent) -> Unit
  lateinit var mousemove: (MouseEvent) -> Unit
  lateinit var mouseout: (MouseEvent) -> Unit
  lateinit var mouseover: (MouseEvent) -> Unit
  lateinit var mouseup: (MouseEvent) -> Unit
  lateinit var mousewheel: (WheelEvent) -> Unit
  lateinit var MSContentZoom: (UIEvent) -> Unit
  lateinit var MSManipulationStateChanged: (Event) -> Unit //MSManipulationEvent
  lateinit var paste: (Event) -> Unit //ClipboardEvent
  lateinit var pause: (Event) -> Unit
  lateinit var play: (Event) -> Unit
  lateinit var playing: (Event) -> Unit
  lateinit var progress: (ProgressEvent) -> Unit
  lateinit var ratechange: (Event) -> Unit
  lateinit var reset: (Event) -> Unit
  lateinit var scroll: (UIEvent) -> Unit
  lateinit var seeked: (Event) -> Unit
  lateinit var seeking: (Event) -> Unit
  lateinit var select: (UIEvent) -> Unit
  lateinit var selectstart: (Event) -> Unit
  lateinit var stalled: (Event) -> Unit
  lateinit var submit: (Event) -> Unit
  lateinit var suspend: (Event) -> Unit
  lateinit var timeupdate: (Event) -> Unit
  lateinit var volumechange: (Event) -> Unit
  lateinit var waiting: (Event) -> Unit
  lateinit var ariarequest: (Event) -> Unit
  lateinit var command: (Event) -> Unit
  lateinit var gotpointercapture: (Event) -> Unit //PointerEvent
  lateinit var lostpointercapture: (Event) -> Unit //PointerEvent
  lateinit var MSGestureChange: (Event) -> Unit //MSGestureEvent
  lateinit var MSGestureDoubleTap: (Event) -> Unit //MSGestureEvent
  lateinit var MSGestureEnd: (Event) -> Unit //MSGestureEvent
  lateinit var MSGestureHold: (Event) -> Unit //MSGestureEvent
  lateinit var MSGestureStart: (Event) -> Unit //MSGestureEvent
  lateinit var MSGestureTap: (Event) -> Unit //MSGestureEvent
  lateinit var MSGotPointerCapture: (Event) -> Unit //PointerEvent
  lateinit var MSInertiaStart: (Event) -> Unit //MSGestureEvent
  lateinit var MSLostPointerCapture: (Event) -> Unit //PointerEvent
  lateinit var MSPointerCancel: (Event) -> Unit //PointerEvent
  lateinit var MSPointerDown: (Event) -> Unit //PointerEvent
  lateinit var MSPointerEnter: (Event) -> Unit //PointerEvent
  lateinit var MSPointerLeave: (Event) -> Unit //PointerEvent
  lateinit var MSPointerMove: (Event) -> Unit //PointerEvent
  lateinit var MSPointerOut: (Event) -> Unit //PointerEvent
  lateinit var MSPointerOver: (Event) -> Unit //PointerEvent
  lateinit var MSPointerUp: (Event) -> Unit //PointerEvent
  lateinit var touchcancel: (Event) -> Unit //TouchEvent
  lateinit var touchend: (Event) -> Unit //TouchEvent
  lateinit var touchmove: (Event) -> Unit //TouchEvent
  lateinit var touchstart: (Event) -> Unit //TouchEvent
  lateinit var webkitfullscreenchange: (Event) -> Unit
  lateinit var webkitfullscreenerror: (Event) -> Unit
  lateinit var pointercancel: (Event) -> Unit //PointerEvent
  lateinit var pointerdown: (Event) -> Unit //PointerEvent
  lateinit var pointerenter: (Event) -> Unit //PointerEvent
  lateinit var pointerleave: (Event) -> Unit //PointerEvent
  lateinit var pointermove: (Event) -> Unit //PointerEvent
  lateinit var pointerout: (Event) -> Unit //PointerEvent
  lateinit var pointerover: (Event) -> Unit //PointerEvent
  lateinit var pointerup: (Event) -> Unit //PointerEvent
  lateinit var wheel: (WheelEvent) -> Unit
}
