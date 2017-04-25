package com.gbsol.propa

/**
 * Created by gbaldeck on 4/17/2017.
 */
interface PropaEntity

//sealed abstract class PropaEntityType {
//  operator infix fun invoke(entity: PropaEntity) = entity
//}
//
//object renderer: PropaEntityType()
//
//object component: PropaEntityType()

object the
object off

object theWrapper{
  infix fun renderer(entity: PropaRenderer){
    Propa.renderer = entity
  }
}

object offWrapper{
  infix fun with(entity: PropaRenderer) {
    Propa.renderer = entity
  }
}


object Propa{
  var renderer: PropaRenderer? = null

  infix fun has(t: the) = theWrapper
  infix fun kick(o: off) = offWrapper

}


