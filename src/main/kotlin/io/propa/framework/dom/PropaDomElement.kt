package io.propa.framework.dom

import io.propa.framework.common.DelegateProperty
import io.propa.framework.external.snabbdom.*
import kotlin.properties.Delegates

/**
 * Created by gbaldeck on 6/5/2017.
 */
open class PropaDomElement(val selector: String){
  protected lateinit var vnode: VNode
  protected var vnodeData: VNodeData = Any() as VNodeData
  init {
    vnodeData.hero = Any() as Hero
    vnodeData.attachData = Any() as AttachData
    vnodeData.hook = Any() as Hooks
    vnodeData.ns = undefined
    vnodeData.fn = undefined
    vnodeData.args = arrayOf()
    vnodeData.props = Any() as Props
    vnodeData.attrs = Any() as Attrs
    vnodeData.`class` = Any() as Classes
    vnodeData.style = Any() as VNodeStyle
    vnodeData.dataset = Any() as Dataset
    vnodeData.on = Any() as On
    vnodeData.key = undefined
  }
  
  val hero: Hero? by DelegateProperty(vnodeData)
  val attachData: AttachData? by DelegateProperty(vnodeData)
  val hook: Hooks? by DelegateProperty(vnodeData)
  var ns: String? by DelegateProperty(vnodeData)
  val fn: (() -> VNode)? by DelegateProperty(vnodeData)
  val args: Array<dynamic>? by DelegateProperty(vnodeData)
  val props: Props? by DelegateProperty(vnodeData)
  val attrs: Attrs? by DelegateProperty(vnodeData)
  val classes: Classes? by DelegateProperty(vnodeData, "`class`")
  val styles: VNodeStyle? by DelegateProperty(vnodeData, "style")
  val dataset: Dataset? by DelegateProperty(vnodeData)
  val on: On? by DelegateProperty(vnodeData)
  val key: dynamic by DelegateProperty(vnodeData)

  

}