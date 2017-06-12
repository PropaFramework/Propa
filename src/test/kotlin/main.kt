//import io.propa.framework.dom.PropaDomBuilder
//import io.propa.framework.external.snabbdom.SnabbClass
//import io.propa.framework.external.snabbdom.Snabbdom
//import io.propa.framework.external.snabbdom.h
import io.propa.framework.common.jsObjectOf
import io.propa.framework.dom.PropaDomElement
import io.propa.framework.external.snabbdom.*
import org.w3c.dom.get
import kotlin.browser.document

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
  val el = PropaDomElement("sel")
  el.attrs?.let { it["test"] = true }
  console.log(el)
  console.log(toVNode(document.createElement("cooleo")))
  console.log(toVNodeModule)
  console.log(Snabbdom)
  console.log(thunk("", {}, arrayOf(1)))
  console.log(thunk("", 1, {}, arrayOf(1)))

  console.log(htmlDomApi)
  console.log(attributesModule)
  console.log(mapOf("string" to "string"))
  val vnode = h("h1",
      jsObjectOf(
          "key" to 1,
          "style" to jsObjectOf(
              "color" to "red"
          ),
          "props" to jsObjectOf(
              "green" to "blue"
          )
      ),
      "Hola")
  val children = arrayOf(
      vnode,
      h("p", "A simple paragraph.")
  )

//  vnode.data?.let { it["add"] = "data" }
  console.log("vnode: ", vnode)
  console.log("vnode data: ", vnode.data)

  val attachtoo = attachTo(document.getElementsByTagName("propa-app")[0]!!, vnode)
  console.log(attachtoo)
  console.log(attachTo)

//  val builder = PropaDomBuilder()
//  builder.startPropa()
//  builder.patch(document.getElementsByTagName("propa-app")[0],
//      h("propa-app",jsObjectOf(),children))
  console.log("-----------------")
//  console.log(Snabbdom)
  console.log(arrayOf(1))
  console.log(vnode)
//  console.log(SnabbClass)
//  console.log(SnabbClass.default)
  console.log(jsObjectOf("thispair" to "that", "itto" to 123, "null" to null))
}