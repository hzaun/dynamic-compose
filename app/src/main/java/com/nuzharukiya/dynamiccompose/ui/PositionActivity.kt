package com.nuzharukiya.dynamiccompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nuzharukiya.dynamiccompose.model.*
import com.nuzharukiya.dynamiccompose.ui.helpers.ViewHelper.decoupledConstraints
import com.nuzharukiya.dynamiccompose.ui.helpers.ViewHelper.values
import com.nuzharukiya.dynamiccompose.ui.theme.DynamicComposeTheme
import com.nuzharukiya.dynamiccompose.ui.utils.ViewFactory
import com.nuzharukiya.dynamiccompose.utils.DataProvider

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
    val context = LocalContext.current
    val list = DataProvider().getData(context, "view_data_button_type.json")

    Layout(list.toList())
}

@Composable
private fun Layout(list: List<Compose>) {
    DynamicComposeTheme {
        Box(
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