package com.nuzharukiya.dynamiccompose.model

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nuzharukiya.dynamiccompose.ui.utils.ACTION_TYPE

data class RawDataModel (
    val id: String,
    val name: String? = null,
    val text: String? = null,
    val typography: TYPOGRAPHY? = null,
    val padding: Dp = 0.dp,
    val backgroundColor: String? = "#ffffff",
    val textColor: String? = "#000000",
    val viewType: VIEW_TYPE = VIEW_TYPE.BUTTON,
    val action: ACTION_TYPE? = null,
    val constraintLinks: RawConstraintLinks = RawConstraintLinks(),
    val children: List<RawDataModel>? = null
)

data class RawConstraintLinks(
    val left: RawLink? = null,
    val top: RawLink? = null,
    val right: RawLink? = null,
    val bottom: RawLink? = null,
)

data class RawLink(
    val target: String,
    val anchor: String,
    val margin: Float
)