package com.gbsol.propa.core

import kotlinx.html.*
import org.w3c.dom.HTMLElement

/**
 * Created by gbaldeck on 5/7/2017.
 */

open class PROPACOMPONENT(tagName: String, initialAttributes : Map<String, String>, override val consumer : TagConsumer<*>)
  : HTMLTag(tagName, consumer, initialAttributes, null, false, false), HtmlBlockTag

fun PROPACOMPONENT.visitTree(component: PropaComponent){
  PropaComponentManager.map[component.propaId] = component
  PropaComponentManager.tree.startComponent(component)
  component.generateStyleAndScope()
  visit({
    createStyle(component)
    component.template()()
  })
  PropaComponentManager.tree.finishComponent(component)
}

fun PROPACOMPONENT.visitAndFinalizeTree(component: PropaComponent, builder: PropaDomBuilder<*>): HTMLElement{
  if (consumer !== builder) {
    throwPropaException("Somehow the dom builders became mixed.")
  }
  visitTree(component)
  return builder.finalize()
}

fun PROPACOMPONENT.createStyle(component: PropaComponent){
  component.styleCompiled?.let {
    this.style("text/css", it)
  }
}
