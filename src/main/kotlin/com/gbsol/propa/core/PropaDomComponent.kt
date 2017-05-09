package com.gbsol.propa.core

import kotlinx.html.HTMLTag
import kotlinx.html.HtmlBlockTag
import kotlinx.html.TagConsumer

/**
 * Created by gbaldeck on 5/7/2017.
 */
open class PROPACOMPONENT(tagName: String, initialAttributes : Map<String, String>, override val consumer : TagConsumer<*>)
  : HTMLTag(tagName, consumer, initialAttributes, null, false, false), HtmlBlockTag