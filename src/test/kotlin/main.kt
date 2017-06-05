import io.propa.framework.common.jsArrayOf
import io.propa.framework.common.jsObjectOf
import io.propa.framework.external.snabbdom.SnabbClass
import io.propa.framework.external.snabbdom.Snabbdom
import io.propa.framework.external.snabbdom.h

/**
 * Created by gbaldeck on 4/17/2017.
 */
fun main(args: Array<String>){

//  console.log("has class true: ", MyElement::class.extendsOrImplements(PropaElement::class))
//  console.log("has class false: ", PropaElement::class.extendsOrImplements(MyElement::class))
//  console.log("has class false: ", PropaElement::class.extendsOrImplements(PropaElement::class))
//  console.log("has class true: ", PropaElement::class.extendsOrImplements(PropaEntity::class))
//  console.log("has class false: ", PropaEntity::class.extendsOrImplements(PropaElement::class))

//  document.create.style { scoped=true }

  console.log(Snabbdom)
  console.log(h("span"))
  console.log(SnabbClass)
//  console.log(SnabbClass.default)
  console.log(jsObjectOf("thispair" to "that", "itto" to 123, "null" to null))
  console.log(jsArrayOf("test", 1, 3, "too"))
}