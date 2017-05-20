package io.propa.framework.core

import io.propa.framework.common.throwPropaException
import kotlinx.html.*
import org.w3c.dom.HTMLElement

/**
 * Created by gbaldeck on 5/7/2017.
 */

internal class PROPACOMPONENT(tagName: String, initialAttributes : Map<String, String>, override val consumer : TagConsumer<*>)
  : HTMLTag(tagName, consumer, initialAttributes, null, false, false), HtmlBlockTag

internal fun PROPACOMPONENT.visitTree(component: PropaComponent){
  PropaComponentManager.map[component.propaId] = component
  PropaComponentManager.tree.startComponent(component)
  component.generateStyleAndScope()
  visit({
    createStyle(component)
    component.template()()
  })
  PropaComponentManager.tree.finishComponent(component)
}

internal fun PROPACOMPONENT.visitAndFinalizeTree(component: PropaComponent, builder: PropaDomBuilder<*>): HTMLElement {
  if (consumer !== builder) {
    throwPropaException("Somehow the dom builders became mixed.")
  }
  visitTree(component)
  return builder.finalize()
}

internal fun PROPACOMPONENT.createStyle(component: PropaComponent){
  component.styleCompiled?.let {
    this.style("text/css", it)
  }
}
