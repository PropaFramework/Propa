package io.propa.framework.dom

import com.github.snabbdom.*
import io.propa.framework.common.PropaConstant
import io.propa.framework.common.PropaDelegateProperty
import io.propa.framework.common.assertSafeCast

/**
 * Created by gbaldeck on 6/5/2017.
 */
open class PropaDomElement(){
  open lateinit var selector: String
  open lateinit var vnode: VNode
  open var vnodeData: VNodeData = assertSafeCast(Any())
  open val children: Array<dynamic /* VNode | String */> = arrayOf()

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

  private val _getVnodeData = { vnodeData }
  
  val hero: Hero by PropaDelegateProperty(_getVnodeData)
  val attachData: AttachData by PropaDelegateProperty(_getVnodeData)
  val hook: Hooks by PropaDelegateProperty(_getVnodeData)
  var ns: String? by PropaDelegateProperty(_getVnodeData)
  var fn: (() -> VNode)? by PropaDelegateProperty(_getVnodeData)
  val args: Array<dynamic> by PropaDelegateProperty(_getVnodeData)
  val props: Props by PropaDelegateProperty(_getVnodeData)
  val attrs: Attrs by PropaDelegateProperty(_getVnodeData)
  val classes: Classes by PropaDelegateProperty(_getVnodeData, "class")
  val styles: VNodeStyle by PropaDelegateProperty(_getVnodeData, "style")
  val dataset: Dataset by PropaDelegateProperty(_getVnodeData)
  val on: On by PropaDelegateProperty(_getVnodeData)
  var key: dynamic by PropaDelegateProperty(_getVnodeData)

  fun applyAttributes(vararg attrs: Pair<String, String>){
    _applyAttrs(attrs)
  }

  fun applyAttributes(vararg attrs: Pair<String, Number>){
    _applyAttrs(attrs)
  }

  fun applyAttributes(vararg attrs: Pair<String, Boolean>){
    _applyAttrs(attrs)
  }

  private fun _applyAttrs(pairs: Array<out Pair<String, dynamic>>){
    val _attrs: dynamic = attrs
    pairs.forEach {
      (key, value) ->
      _attrs[key] = value
    }
  }

  fun deleteAttributes(vararg keys: String){
    val _attrs: dynamic = attrs
    keys.forEach {
      key ->
      _attrs[key] = PropaConstant.DELETE
    }

    val newAttrs: dynamic = Any()
    val attrKeys = _attrs.keys() as Array<String>
    attrKeys.forEach {
      if(_attrs[key] !== PropaConstant.DELETE)
        newAttrs[key] = _attrs[key]
    }

    val _vnodeData: dynamic = vnodeData
    _vnodeData.attrs = newAttrs
  }
}