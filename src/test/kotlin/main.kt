import com.gbsol.propa.element.template
import kotlinx.html.dom.create
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.*
import kotlinx.html.stream.createHTML
import org.w3c.dom.DocumentFragment
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLTemplateElement
import org.w3c.dom.get
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/17/2017.
 */
fun main(args: Array<String>){

  val html = createHTML().template { template {  div { +"hola"; template { +"sup" } } } }
  println("html: $html")
  val template = document.create.template {
    template { h1 { +"hello"; template {  +"hello"; +"good day" }  } }

  }
  js("console.log('template: ', template)")
  js("console.log('template content: ', template.content)")

  val clone = document.importNode(template.content, true);
  clone.firstChild!!.textContent = "hello 2"
  js("console.log('clone: ', clone)")

  document.body!!.append (clone)

}