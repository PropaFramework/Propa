import com.gbsol.propa.PropaComponent
import com.gbsol.propa.element.template
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.stream.createHTML
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlin.collections.set
import kotlin.reflect.KClass

/**
 * Created by gbaldeck on 4/17/2017.
 */
fun main(args: Array<String>){

  fun testKClass(clazz: KClass<*>){

  }

//  console.log("has class true: ", MyElement::class.extendsOrImplements(PropaElement::class))
//  console.log("has class false: ", PropaElement::class.extendsOrImplements(MyElement::class))
//  console.log("has class false: ", PropaElement::class.extendsOrImplements(PropaElement::class))
//  console.log("has class true: ", PropaElement::class.extendsOrImplements(PropaEntity::class))
//  console.log("has class false: ", PropaEntity::class.extendsOrImplements(PropaElement::class))

//  Propa has the renderer MyRenderer::class


  val html = createHTML().template { template("other gold") {  div { +"hola"; template { attributes["a"] = "b"; +"sup" } } } }
  println("html: $html")
  val template = document.create.template("kind of gold") {
    template { h1 { +"hello"; template {  attributes["class"] = "testa testb testc"}  } }

  }
  js("console.log('template: ', template)")
  js("console.log('template content: ', template.content)")

  val clone = document.importNode(template.content, true);
  clone.firstChild!!.textContent = "hello 2"
  js("console.log('clone: ', clone)")

  document.body!!.append (clone)


}