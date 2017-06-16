package io.propa.framework.di

import io.propa.framework.common.createInstance
import io.propa.framework.common.throwPropaException
import kotlin.reflect.KProperty

/**
 * Created by gbaldeck on 5/11/2017.
 */
interface PropaService

val PropaSingletons = mutableMapOf<String, PropaService>()

class PropaInject{
  inline operator fun <reified T: PropaService> getValue(thisRef: Any, property: KProperty<*>): T =
    T::class.simpleName?.let {

      if (!PropaSingletons.contains(T::class.simpleName))
        PropaSingletons[it] = T::class.createInstance()

      PropaSingletons[it] as T

    } ?: throwPropaException("A PropaService cannot be an anonymous object or class.")
}
