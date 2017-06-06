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

external interface HTMLElementEventMap : ElementEventMap {
    var abort: UIEvent
    var activate: UIEvent
    var beforeactivate: UIEvent
    var beforecopy: ClipboardEvent
    var beforecut: ClipboardEvent
    var beforedeactivate: UIEvent
    var beforepaste: ClipboardEvent
    var blur: FocusEvent
    var canplay: Event
    var canplaythrough: Event
    var change: Event
    var click: MouseEvent
    var contextmenu: PointerEvent
    var copy: ClipboardEvent
    var cuechange: Event
    var cut: ClipboardEvent
    var dblclick: MouseEvent
    var deactivate: UIEvent
    var drag: DragEvent
    var dragend: DragEvent
    var dragenter: DragEvent
    var dragleave: DragEvent
    var dragover: DragEvent
    var dragstart: DragEvent
    var drop: DragEvent
    var durationchange: Event
    var emptied: Event
    var ended: MediaStreamErrorEvent
    var error: ErrorEvent
    var focus: FocusEvent
    var input: Event
    var invalid: Event
    var keydown: KeyboardEvent
    var keypress: KeyboardEvent
    var keyup: KeyboardEvent
    var load: Event
    var loadeddata: Event
    var loadedmetadata: Event
    var loadstart: Event
    var mousedown: MouseEvent
    var mouseenter: MouseEvent
    var mouseleave: MouseEvent
    var mousemove: MouseEvent
    var mouseout: MouseEvent
    var mouseover: MouseEvent
    var mouseup: MouseEvent
    var mousewheel: WheelEvent
    var MSContentZoom: UIEvent
    var MSManipulationStateChanged: MSManipulationEvent
    var paste: ClipboardEvent
    var pause: Event
    var play: Event
    var playing: Event
    var progress: ProgressEvent
    var ratechange: Event
    var reset: Event
    var scroll: UIEvent
    var seeked: Event
    var seeking: Event
    var select: UIEvent
    var selectstart: Event
    var stalled: Event
    var submit: Event
    var suspend: Event
    var timeupdate: Event
    var volumechange: Event
    var waiting: Event
}
external interface ElementEventMap : GlobalEventHandlersEventMap {
    var ariarequest: Event
    var command: Event
    var gotpointercapture: PointerEvent
    var lostpointercapture: PointerEvent
    var MSGestureChange: MSGestureEvent
    var MSGestureDoubleTap: MSGestureEvent
    var MSGestureEnd: MSGestureEvent
    var MSGestureHold: MSGestureEvent
    var MSGestureStart: MSGestureEvent
    var MSGestureTap: MSGestureEvent
    var MSGotPointerCapture: MSPointerEvent
    var MSInertiaStart: MSGestureEvent
    var MSLostPointerCapture: MSPointerEvent
    var MSPointerCancel: MSPointerEvent
    var MSPointerDown: MSPointerEvent
    var MSPointerEnter: MSPointerEvent
    var MSPointerLeave: MSPointerEvent
    var MSPointerMove: MSPointerEvent
    var MSPointerOut: MSPointerEvent
    var MSPointerOver: MSPointerEvent
    var MSPointerUp: MSPointerEvent
    var touchcancel: TouchEvent
    var touchend: TouchEvent
    var touchmove: TouchEvent
    var touchstart: TouchEvent
    var webkitfullscreenchange: Event
    var webkitfullscreenerror: Event
}
external interface GlobalEventHandlersEventMap {
    var pointercancel: PointerEvent
    var pointerdown: PointerEvent
    var pointerenter: PointerEvent
    var pointerleave: PointerEvent
    var pointermove: PointerEvent
    var pointerout: PointerEvent
    var pointerover: PointerEvent
    var pointerup: PointerEvent
    var wheel: WheelEvent
}
