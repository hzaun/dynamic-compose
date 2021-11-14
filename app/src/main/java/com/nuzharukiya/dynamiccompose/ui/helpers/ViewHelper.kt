package com.nuzharukiya.dynamiccompose.ui.helpers

import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope
import androidx.constraintlayout.compose.ConstraintSet
import com.nuzharukiya.dynamiccompose.model.*
import com.nuzharukiya.dynamiccompose.ui.utils.ACTION_TYPE

/**
 * @author Nuzha Rukiya <r.nuzha@gmail.com>
 * @version $Revision 1.0 $, $Date 2021/04/29 19:12 $
 * @since,
 *
 * Developed for Dynamic Compose
 */
object ViewHelper {
    fun values(
        metaDataId: String,
        dataId: String? = null,
        text: String? = null,
        typography: TYPOGRAPHY? = null,
        padding: Int = 0,
        backgroundColor: String = "#ffffff",
        textColor: String = "#000000",
        viewType: VIEW_TYPE = VIEW_TYPE.BUTTON,
        action: ACTION_TYPE? = null,
        constraintLinks: ConstraintLink = ConstraintLink(),
        children: List<Compose>? = null
    ): Compose {
        val pad = padding.dp

        val meta = MetaData(
            metaDataId,
            pad,
            backgroundColor,
            textColor,
            typography,
            viewType,
            constraintLinks = constraintLinks,
            action = action
        )
        val data = ComposeData("Test", text, children)

        return Compose(meta, data)
    }

    fun decoupledConstraints(list: List<Compose>): ConstraintSet {
        return ConstraintSet {
            val clRefs = hashMapOf<String, ConstrainedLayoutReference>()
            list.forEach {
                clRefs[it.metaData.id] = createRefFor(it.metaData.id)
            }

            list.forEach {
                val constraintLink = it.metaData.constraintLinks
                val constraintId: String = it.metaData.id
                constrain(clRefs[constraintId] ?: createRefFor(constraintId)) {
                    clRefs["parent"] = parent
                    constraintLink.left?.let { link ->
                        clRefs[link.item]?.let { clRef ->
                            start.linkTo(clRef.getVerRef(link.constraint), link.margin)
                        }
                    }
                    constraintLink.top?.let { link ->
                        clRefs[link.item]?.let { clRef ->
                            top.linkTo(clRef.getHorRef(link.constraint), link.margin)
                        }
                    }
                    constraintLink.right?.let { link ->
                        clRefs[link.item]?.let { clRef ->
                            end.linkTo(clRef.getVerRef(link.constraint), link.margin)
                        }
                    }
                    constraintLink.bottom?.let { link ->
                        clRefs[link.item]?.let { clRef ->
                            bottom.linkTo(clRef.getHorRef(link.constraint), link.margin)
                        }
                    }
                }
            }
        }
    }
}

fun ConstrainedLayoutReference.getVerRef(constraint: CONSTRAINT_OPTIONS): ConstraintLayoutBaseScope.VerticalAnchor {
    return when (constraint) {
        CONSTRAINT_OPTIONS.RIGHT -> this.end
        else -> this.start
    }
}

fun ConstrainedLayoutReference.getHorRef(constraint: CONSTRAINT_OPTIONS): ConstraintLayoutBaseScope.HorizontalAnchor {
    return when (constraint) {
        CONSTRAINT_OPTIONS.BOTTOM -> this.bottom
        else -> this.top
    }
}