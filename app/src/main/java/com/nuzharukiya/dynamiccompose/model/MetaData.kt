package com.nuzharukiya.dynamiccompose.model

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.gson.annotations.JsonAdapter
import com.nuzharukiya.dynamiccompose.ui.utils.ACTION_TYPE
import com.nuzharukiya.dynamiccompose.utils.DpAdapter

/**
 * @author Nuzha Rukiya <r.nuzha@gmail.com>
 * @version $Revision 1.0 $, $Date 2021/04/29 14:59 $
 * @since
 *
 * Developed for Dynamic Compose
 */
data class MetaData(
    val id: String,
    val padding: Dp = 0.dp,
    val backgroundColor: String,
    val textColour: String,
    val typography: TYPOGRAPHY? = null,
    val viewType: VIEW_TYPE,
    val action: ACTION_TYPE? = null,
    val alignment: ALIGNMENT? = null,
    val constraintLinks: ConstraintLink
)

data class ConstraintLink(
    val left: Link? = null,
    val top: Link? = null,
    val right: Link? = null,
    val bottom: Link? = null
)

data class Link(
    val item: String,
    val constraint: CONSTRAINT_OPTIONS,
    @JsonAdapter(DpAdapter::class)
    val margin: Dp = 0.dp
)

enum class TYPOGRAPHY {
    BUTTON,
    SUBTITLE1,
    TITLE
}

enum class CONSTRAINT_OPTIONS {
    LEFT,
    TOP,
    RIGHT,
    BOTTOM
}

enum class ALIGNMENT {
    CENTER,
    START,
    TOP,
    END,
    BOTTOM
}

enum class POSITION {
    BELOW
}

enum class VIEW_TYPE {
    BUTTON,
    TEXT,
    LAYOUT
}