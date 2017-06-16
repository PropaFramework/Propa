package io.propa.framework.common

import io.propa.framework.external.snabbdom._get
import io.propa.framework.external.snabbdom._set
import kotlin.reflect.KProperty

/**
 * Created by gbaldeck on 6/16/2017.
 */
class PropaAssignOnce<T>(val exceptionMsgGet: String? = null, val exceptionMsgSet: String? = null){
  private var value: T? = null

  operator fun getValue(thisRef: Any, property: KProperty<*>): T =
    value ?: throwPropaException(exceptionMsgGet ?: "Property '${property.name}' in ${thisRef::class.simpleName} has not been set.")

  operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) =
    if(this.value == null)
      this.value = value
    else
      throwPropaException(exceptionMsgSet ?: "Property '${property.name}' in ${thisRef::class.simpleName} has already been set.")
}

class PropaDelegateProperty(val backingObj: Any, val propertyName: String? = null){
  operator fun getValue(thisRef: Any?, property: KProperty<*>): dynamic =
    backingObj._get(propertyName ?: property.name)

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: dynamic) {
    backingObj._set(propertyName ?: property.name, value)
  }
}