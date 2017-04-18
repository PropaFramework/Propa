import kotlinx.html.*
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLTemplateElement

/**
 * Created by gbaldeck on 4/17/2017.
 */
interface HtmlTemplateTag : kotlinx.html.CommonAttributeGroupFacade, kotlinx.html.FlowPhrasingContent, kotlinx.html.HtmlBlockTag, kotlinx.html.HtmlInlineTag {
}

@Suppress("unused")
open class TEMPLATE(initialAttributes : Map<String, String>, override val consumer : TagConsumer<*>) : HTMLTag("template", consumer, initialAttributes, "http://www.w3.org/2000/svg", false, false), HtmlBlockInlineTag {

}
val TEMPLATE.asFlowContent : FlowContent
  get()  = this

val TEMPLATE.asPhrasingContent : PhrasingContent
  get()  = this

public fun TagConsumer<HTMLElement>.div(classes : String? = null, block : DIV.() -> Unit = {}) : HTMLTemplateElement = DIV(attributesMapOf("class", classes), this).visitAndFinalize(this, block) as HTMLTemplateElement