package io.propa.framework.di

import io.propa.framework.common.createInstance
import io.propa.framework.common.throwPropaException
import kotlin.reflect.KProperty

/**
 * Created by gbaldeck on 5/11/2017.
 */
object PropaInject {
  val singletons = mutableMapOf<String, PropaService>()

  inline operator fun <reified T : PropaService> invoke(): PropaDelegateInjector<T> {
    if (T::class.simpleName == null)
      throwPropaException("A PropaService cannot be an anonymous object or class.")

    if (!singletons.contains(T::class.simpleName))
      singletons[T::class.simpleName!!] = T::class.createInstance()

    return PropaDelegateInjector<T>(singletons[T::class.simpleName] as T)
  }
}

interface PropaService

class PropaDelegateInjector<out T : PropaService>(val service: T) {
  operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    return service
  }
}