package io.propa.framework.common

/**
 * Created by gbaldeck on 4/24/2017.
 */
class PropaException(message: String?): Exception("PropaException: "+message)
fun throwPropaException(message: String? = null): Nothing = throw PropaException(message)