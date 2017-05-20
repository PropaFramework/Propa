package io.propa.framework.core

import org.w3c.dom.HTMLElement
import kotlin.reflect.KProperty

/**
 * Created by gbaldeck on 5/20/2017.
 */

class PropaDetect<V>(initialValue: V){
  private var value = initialValue
  operator fun<T: PropaComponent> getValue(thisRef: T, property: KProperty<*>): V {
    return value
  }

  operator fun<T: PropaComponent> setValue(thisRef: T, property: KProperty<*>, value: V) {
    this.value = value
    val newElement = PropaComponentManager.renderer.startPropa(thisRef)
    val element = thisRef.element



  }
}

class PropaMutationObserver(element: HTMLElement){
  init{

  }
}