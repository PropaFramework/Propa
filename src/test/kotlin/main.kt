import io.propa.framework.common.jsArrayOf
import io.propa.framework.common.jsObjectOf
import io.propa.framework.external.snabbdom.*
import org.w3c.dom.events.Event
import org.w3c.dom.events.UIEvent
//import io.propa.framework.dom.PropaDomBuilder
//import io.propa.framework.external.snabbdom.SnabbClass
//import io.propa.framework.external.snabbdom.Snabbdom
//import io.propa.framework.external.snabbdom.h
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

  console.log(array(arrayOf(1)))
  console.log(primitive(""))

  val on = On()
  console.log(htmlDomApi)
  console.log(attributesModule)
  val attrs = Attrs()
  attrs["test"] = true
  val get = attrs["test"] as Boolean
  console.log(get)
  val props = Props()
  props["test"] = 1
  val vnodeData = VNodeData()
  vnodeData.props = props
  console.log(props)
  console.log(vnodeData)
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
  val children = jsArrayOf(
      vnode,
      h("p", "A simple paragraph.")
  ) as Array<VNode?>

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
  console.log(jsArrayOf("test", 1, 3, "too"))
}