package io.propa.framework.core

import io.propa.framework.common.throwPropaException

/**
 * Created by gbaldeck on 5/10/2017.
 */
internal class PropaComponentTreeNode(val component: PropaComponent, val parent: PropaComponentTreeNode? = null) {
  val id
    get() = component.propaId

  val children = arrayListOf<PropaComponentTreeNode>()

  init {
    component.treeNode = this
  }
}

internal class PropaComponentTree{
  private var _root: PropaComponentTreeNode? = null
  private var _currentNode: PropaComponentTreeNode? = null

  val currentNode: PropaComponentTreeNode
    get(){
      if(_currentNode == null)
        throwPropaException("The component tree has not started or is done traversing.")

      return _currentNode!!
    }

  //Every call to startComponent needs a later call to finishComponent
  fun startComponent(component: PropaComponent){
    val node: PropaComponentTreeNode

    if(_root == null) {
      node = PropaComponentTreeNode(component)
      _root = node
    } else {
      node = PropaComponentTreeNode(component, _currentNode)
      _currentNode!!.children += node
    }
    _currentNode = node
  }

  //every call to finishComponent needs to be preceded by a call to startComponent
  fun finishComponent(component: PropaComponent){
    if(_currentNode == null)
      throwPropaException("The component tree has not begun building yet.")

    if(component.propaId != _currentNode!!.id)
      throwPropaException("The component tree has gotten out of sync.")

    _currentNode = _currentNode!!.parent

  }
}