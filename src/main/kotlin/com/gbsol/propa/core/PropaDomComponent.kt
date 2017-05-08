package com.gbsol.propa.core

import kotlinx.html.HTMLTag
import kotlinx.html.HtmlBlockTag
import kotlinx.html.TagConsumer
import kotlinx.html.attributesMapOf

/**
 * Created by gbaldeck on 5/7/2017.
 */
open class PROPACOMPONENT(tagName: String, override val consumer : TagConsumer<*>) : HTMLTag(tagName, consumer, attributesMapOf(), null, false, false), HtmlBlockTag