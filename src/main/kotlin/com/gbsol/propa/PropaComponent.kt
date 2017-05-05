package com.gbsol.propa

import kotlinx.html.HTML

/**
 * Created by gbaldeck on 4/21/2017.
 */
interface PropaComponent {
  fun template(): PropaTemplate
  fun render() = "Im good"
  companion object
}

abstract class PropaEntryComponent: PropaComponent{
}


//interface PropaTemplate: Tag{
//  operator fun invoke()
//}

typealias PropaTemplate = HTML.() -> Unit