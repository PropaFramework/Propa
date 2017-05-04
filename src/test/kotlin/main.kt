import com.gbsol.propa.*
import com.gbsol.propa.element.template
import kotlinx.html.dom.create
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.*
import kotlinx.html.stream.createHTML
import org.w3c.dom.DocumentFragment
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLTemplateElement
import org.w3c.dom.events.Event
import org.w3c.dom.get
import kotlin.browser.document
import kotlin.browser.window

/**
 * Created by gbaldeck on 4/17/2017.
 */
fun main(args: Array<String>){

  console.log("has class true: ", MyElement::class.extendsOrImplements(PropaElement::class))
  console.log("has class false: ", PropaElement::class.extendsOrImplements(MyElement::class))
  console.log("has class false: ", PropaElement::class.extendsOrImplements(PropaElement::class))
  console.log("has class true: ", PropaElement::class.extendsOrImplements(PropaEntity::class))
  console.log("has class false: ", PropaEntity::class.extendsOrImplements(PropaElement::class))

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

  window.customElements.define("my-custom-element", MyWebComponent::class.js)

}

class MyRenderer: TagConsumer<HTMLElement> {
  override fun finalize(): HTMLElement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onTagAttributeChange(tag: Tag, attribute: String, value: String?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onTagContent(content: CharSequence) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onTagContentEntity(entity: Entities) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onTagContentUnsafe(block: Unsafe.() -> Unit) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onTagEnd(tag: Tag) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onTagEvent(tag: Tag, event: String, value: (Event) -> Unit) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onTagStart(tag: Tag) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}