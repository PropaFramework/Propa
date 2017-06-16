package io.propa.framework.dom

import io.propa.framework.common.assertSafeCast
import io.propa.framework.common.PropaDelegateProperty
import io.propa.framework.external.snabbdom.*

/**
 * Created by gbaldeck on 6/5/2017.
 */
open class PropaDomElement(){
  open lateinit var selector: String
  lateinit var vnode: VNode
  var vnodeData: VNodeData = assertSafeCast(Any())
  val children: Array<dynamic /* VNode | String */> = arrayOf()

  constructor(selector: String): this() {
    this.selector = selector
  }

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
  
  val hero: Hero? by PropaDelegateProperty(vnodeData)
  val attachData: AttachData? by PropaDelegateProperty(vnodeData)
  val hook: Hooks? by PropaDelegateProperty(vnodeData)
  var ns: String? by PropaDelegateProperty(vnodeData)
  var fn: (() -> VNode)? by PropaDelegateProperty(vnodeData)
  val args: Array<dynamic>? by PropaDelegateProperty(vnodeData)
  val props: Props? by PropaDelegateProperty(vnodeData)
  val attrs: Attrs? by PropaDelegateProperty(vnodeData)
  val classes: Classes? by PropaDelegateProperty(vnodeData, "class")
  val styles: VNodeStyle? by PropaDelegateProperty(vnodeData, "style")
  val dataset: Dataset? by PropaDelegateProperty(vnodeData)
  val on: On? by PropaDelegateProperty(vnodeData)
  var key: dynamic by PropaDelegateProperty(vnodeData)

  operator fun String.unaryPlus(){
    children[children.size] = this
  }

}