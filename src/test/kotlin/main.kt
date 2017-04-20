import com.gbsol.propa.element.template
import kotlinx.html.dom.create
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.*
import org.w3c.dom.DocumentFragment
import org.w3c.dom.HTMLTemplateElement
import org.w3c.dom.get
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/17/2017.
 */
fun main(args: Array<String>){
  val node = document.getElementsByTagName("propa-app");
  val otherHtml = document.create.div {
    h1 { +"It worked !" }
  }

  val template = document.create.template {
    h1 { +"My template is awesome" }
  }
  js("console.log('template: ', template)")
  js("console.log('template content: ', template.content)")

  val clone = document.importNode(template.content, true);
  js("console.log('clone: ', clone)")

  val documentFragment: DocumentFragment
  js("documentFragment = template.content")
  document.body!!.append { template { h1 { +"Template test" } } }
  node[0]?.replaceWith(otherHtml)

//  val temp1 = document.getElementsByTagName("template")[0] as HTMLTemplateElement

//  val cl = document.importNode(temp1.content, true);

//  document.body!!.appendChild(cl)
}