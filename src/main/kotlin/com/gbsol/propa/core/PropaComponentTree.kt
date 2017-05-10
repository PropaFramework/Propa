package com.gbsol.propa.core

/**
 * Created by gbaldeck on 5/10/2017.
 */
class PropaComponentTreeNode(val component: PropaComponent, val parent: PropaComponentTreeNode? = null) {
  val id
    get() = component.propaId

  val children = arrayListOf<PropaComponentTreeNode>()

  val path = arrayListOf<String>()

  init {
    if (parent != null)
      path.addAll(parent.path)

    path.add(id)
    component.treeNode = this
  }
}

class PropaComponentTree{
  private val path = arrayListOf<PropaComponentTreeNode>()
  private var _root: PropaComponentTreeNode? = null
  private var _currentNode: PropaComponentTreeNode? = null

  val root: PropaComponentTreeNode
    get() {
      if(_root == null)
        throwPropaException("The PropaComponentTree has no root element.")

      return _root!!
    }

  val currentNode: PropaComponentTreeNode
    get() {
      if(_currentNode == null)
        throwPropaException("The component tree has not begun building yet.")

      return _currentNode!!
    }

  //Every call to startComponent will also need a call to finishComponent
  fun startComponent(component: PropaComponent){
    val node: PropaComponentTreeNode

    if(_root == null) {
      node = PropaComponentTreeNode(component)
      _root = node
      _currentNode = node
    } else {
      node = PropaComponentTreeNode(component, _currentNode)
      _currentNode!!.children += node
    }

    path += node
  }

  //every call to finishComponent also needs to be preceded by a call to startComponent
  fun finishComponent(component: PropaComponent){
    if(_currentNode == null)
      throwPropaException("The component tree has not begun building yet.")

    if(component.propaId != _currentNode!!.id)
      throwPropaException("The component tree has gotten out of sync.")

    _currentNode = path.removeAt(path.lastIndex)
  }
}