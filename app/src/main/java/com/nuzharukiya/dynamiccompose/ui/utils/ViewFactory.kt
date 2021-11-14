package com.nuzharukiya.dynamiccompose.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nuzharukiya.dynamiccompose.ui.helpers.ViewHelper
import com.nuzharukiya.dynamiccompose.model.Compose
import com.nuzharukiya.dynamiccompose.model.TYPOGRAPHY
import com.nuzharukiya.dynamiccompose.model.VIEW_TYPE
import com.nuzharukiya.dynamiccompose.utils.ColorUtils
import com.nuzharukiya.dynamiccompose.utils.ViewUtils

/**
 * @author Nuzha Rukiya <r.nuzha@gmail.com>
 * @version $Revision 1.0 $, $Date 2021/04/29 15:32 $
 * @since
 *
 * Developed for Dynamic Compose
 */
object ViewFactory {

    @Composable
    fun makeView(compose: Compose) {
        return when (compose.metaData.viewType) {
            VIEW_TYPE.BUTTON -> {
                ComposeButton(compose)
            }
            VIEW_TYPE.TEXT -> {
                ComposeText(compose)
            }
            VIEW_TYPE.LAYOUT -> {
                ComposeLayout(compose)
            }
        }
    }

    @Composable
    fun ComposeLayout(compose: Compose) {
        return Column(
            Modifier
                .layoutId(compose.metaData.id)
                .padding(compose.metaData.padding)
                .background(
                    Color(android.graphics.Color.parseColor(compose.metaData.backgroundColor)),
                    RectangleShape
                )
        ) {
            compose.composeData.children?.let { list ->
                BoxWithConstraints(
                    Modifier.padding(16.dp)
                ) {
                    ConstraintLayout(ViewHelper.decoupledConstraints(list)) {
                        compose.composeData.children?.forEach {
                            makeView(it)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ComposeText(compose: Compose, typography: TYPOGRAPHY? = null) {
        return Text(
            compose.composeData.text ?: "Default Text",
            color = ColorUtils().stringToColor(compose.metaData.textColour),
            style = ViewUtils().getTypography(typography ?: compose.metaData.typography),
            textAlign = ViewUtils().getTextAlignment(compose.metaData.alignment),
            modifier = Modifier
                .layoutId(compose.metaData.id)
                .padding(compose.metaData.padding)
                .background(
                    Color(android.graphics.Color.parseColor(compose.metaData.backgroundColor)),
                    RectangleShape
                )
        )
    }

    @Composable
    fun ComposeButton(compose: Compose) {
        return Button(
            onClick = { ActionFactory.execute(compose) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ColorUtils().stringToColor(compose.metaData.backgroundColor)
            ),
            modifier = Modifier
                .layoutId(compose.metaData.id)
                .padding(compose.metaData.padding),
        ) {
            ComposeText(compose, TYPOGRAPHY.BUTTON)
        }

    }
}

@Preview
@Composable
fun DefaultPreview() {
    ViewFactory.ComposeButton(ViewHelper.values("TestPosition", "Lorem Ipsum"))
    //    ViewFactory.ComposeText(ViewHelper.values("TestPosition"))
}