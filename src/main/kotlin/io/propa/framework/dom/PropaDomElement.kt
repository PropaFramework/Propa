package io.propa.framework.dom

import io.propa.framework.common.DelegateProperty
import io.propa.framework.common.assertSafeCast
import io.propa.framework.external.snabbdom.*

/**
 * Created by gbaldeck on 6/5/2017.
 */
open class PropaDomElement(val selector: String){
  protected lateinit var vnode: VNode
  protected var vnodeData: VNodeData = assertSafeCast(Any())
  val children: Array<dynamic /* VNode | String */> = arrayOf()

  init {
    vnodeData.hero = assertSafeCast(Any())
    vnodeData.attachData = assertSafeCast(Any())
    vnodeData.hook = assertSafeCast(Any())
    vnodeData.ns = undefined
    vnodeData.fn = undefined
    vnodeData.args = arrayOf()
    vnodeData.props = assertSafeCast(Any())
    vnodeData.attrs = assertSafeCast(Any())
    vnodeData.`class` = assertSafeCast(Any())
    vnodeData.style = assertSafeCast(Any())
    vnodeData.dataset = assertSafeCast(Any())
    vnodeData.on = assertSafeCast(Any())
    vnodeData.key = undefined
  }
  
  val hero: Hero? by DelegateProperty(vnodeData)
  val attachData: AttachData? by DelegateProperty(vnodeData)
  val hook: Hooks? by DelegateProperty(vnodeData)
  var ns: String? by DelegateProperty(vnodeData)
  var fn: (() -> VNode)? by DelegateProperty(vnodeData)
  val args: Array<dynamic>? by DelegateProperty(vnodeData)
  val props: Props? by DelegateProperty(vnodeData)
  val attrs: Attrs? by DelegateProperty(vnodeData)
  val classes: Classes? by DelegateProperty(vnodeData, "class")
  val styles: VNodeStyle? by DelegateProperty(vnodeData, "style")
  val dataset: Dataset? by DelegateProperty(vnodeData)
  val on: On? by DelegateProperty(vnodeData)
  var key: dynamic by DelegateProperty(vnodeData)

  operator fun String.unaryPlus(){
    children[children.size] = this
  }

}