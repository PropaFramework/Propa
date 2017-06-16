package io.propa.framework.component

import io.propa.framework.common.throwPropaException

/**
 * Created by gbaldeck on 5/10/2017.
 */
internal class PropaComponentTreeNode(val component: PropaComponent, val parent: PropaComponentTreeNode? = null) {
  val id
    get() = component.propaId

  val children = mutableListOf<PropaComponentTreeNode>()

  init {
    component.treeNode = this
  }
}

internal class PropaComponentTree{
  private var _root: PropaComponentTreeNode? = null
  private var _currentNode: PropaComponentTreeNode? = null

  val currentNode: PropaComponentTreeNode
    get() = _currentNode ?: throwPropaException("The component tree has not started or is done traversing.")

  //Every call to startComponent needs a later call to finishComponent
  fun startComponent(component: PropaComponent){
    val node = PropaComponentTreeNode(component, _currentNode)

    _root?.also {
      _currentNode?.apply {
        children += node
      }
    } ?: run {
      _root = node
    }

    _currentNode = node
  }

  //every call to finishComponent needs to be preceded by a call to startComponent
  fun finishComponent(component: PropaComponent){
    _currentNode?.also {
      if (component.propaId != it.id)
        throwPropaException("The component tree has gotten out of sync.")

      _currentNode = it.parent
    } ?: throwPropaException("The component tree has not begun building yet.")
  }
}