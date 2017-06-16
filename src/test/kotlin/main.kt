//import io.propa.framework.dom.PropaDomBuilder
//import io.propa.framework.external.snabbdom.SnabbClass
//import io.propa.framework.external.snabbdom.Snabbdom
//import io.propa.framework.external.snabbdom.h
import io.propa.framework.Propa
import io.propa.framework.common.jsObjectOf
import io.propa.framework.dom.PropaDomElement
import io.propa.framework.external.snabbdom.*
import org.w3c.dom.get
import kotlin.browser.document

/**
 * Created by gbaldeck on 4/17/2017.
 */
fun main(args: Array<String>){
  Propa.entryComponent(EntryComponent)
}