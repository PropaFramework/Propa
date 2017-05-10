package com.gbsol.propa.core

import kotlinx.html.*

/**
 * Created by gbaldeck on 5/7/2017.
 */

open class PROPACOMPONENT(tagName: String, initialAttributes : Map<String, String>, override val consumer : TagConsumer<*>)
  : HTMLTag(tagName, consumer, initialAttributes, null, false, false), HtmlBlockTag

fun PROPACOMPONENT.visitTree(component: PropaComponent, block: PROPACOMPONENT.() -> Unit){
  treeCore(component) {
    visit(block)
  }
}

fun PROPACOMPONENT.visitAndFinalizeTree(component: PropaComponent, builder: PropaDomBuilder<*>, block: PROPACOMPONENT.() -> Unit){
  treeCore(component) {
    visitAndFinalize(builder, block)
  }
}

fun PROPACOMPONENT.treeCore(component: PropaComponent, block: PROPACOMPONENT.() -> Unit){
  PropaComponentManager.componentMap[component.propaId] = component
  PropaComponentManager.tree.startComponent(component)
  component.treeNode?.path?.forEach {
    attributes.put(it, "")
  }
  console.log(component)
  console.log(component.treeNode)
  block()
  PropaComponentManager.tree.finishComponent(component)
}

fun PROPACOMPONENT.createStyle(component: PropaComponent){
  component.generatedCss?.let {
    this.style("text/css", it)
  }
}