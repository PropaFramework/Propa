import kotlinx.html.dom.create
import kotlinx.html.*
import kotlinx.html.js.*
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

  node[0]?.replaceWith(otherHtml)
}