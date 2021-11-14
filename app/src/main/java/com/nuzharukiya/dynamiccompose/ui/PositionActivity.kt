package com.nuzharukiya.dynamiccompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nuzharukiya.dynamiccompose.model.*
import com.nuzharukiya.dynamiccompose.ui.helpers.ViewHelper.decoupledConstraints
import com.nuzharukiya.dynamiccompose.ui.helpers.ViewHelper.values
import com.nuzharukiya.dynamiccompose.ui.theme.DynamicComposeTheme
import com.nuzharukiya.dynamiccompose.ui.utils.ViewFactory

class PositionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchData()
        }
    }
}

@Composable
private fun FetchData() {
    val list = mutableListOf(
        values(
            "b1",
            "Text 1",
            backgroundColor = "#d2acf5",
            textColor = "#ffffff",
            viewType = VIEW_TYPE.BUTTON,
            constraintLinks = ConstraintLink(
                left = Link("parent", CONSTRAINT_OPTIONS.LEFT),
                top = Link("parent", CONSTRAINT_OPTIONS.TOP)
            )
        ),
        values(
            "b2",
            "Text 2",
            backgroundColor = "#0095ff",
            textColor = "#ffffff",
            viewType = VIEW_TYPE.BUTTON,
            constraintLinks = ConstraintLink(
                left = Link("b1", CONSTRAINT_OPTIONS.RIGHT, 16.dp),
                top = Link("b1", CONSTRAINT_OPTIONS.TOP)
            )
        )
    )

    Layout(list.toList())
}

@Composable
private fun Layout(list: List<Compose>) {
    DynamicComposeTheme {
        BoxWithConstraints(
            Modifier.padding(16.dp)
        ) {
            ConstraintLayout(decoupledConstraints(list)) {
                list.forEach {
                    ViewFactory.makeView(it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    DynamicComposeTheme {
        FetchData()
    }
}