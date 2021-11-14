package com.nuzharukiya.dynamiccompose.model

/**
 * @author Nuzha Rukiya <r.nuzha@gmail.com>
 * @version $Revision 1.0 $, $Date 2021/04/29 15:42 $
 * @since
 *
 * Developed for Dynamic Compose
 */
data class ComposeData(
    val id: String,
    val text: String?,
    val children: List<Compose>? = null
)