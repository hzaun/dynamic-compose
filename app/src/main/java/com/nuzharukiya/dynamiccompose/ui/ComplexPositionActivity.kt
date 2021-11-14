package com.nuzharukiya.dynamiccompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nuzharukiya.dynamiccompose.model.Compose
import com.nuzharukiya.dynamiccompose.ui.helpers.ViewHelper.decoupledConstraints
import com.nuzharukiya.dynamiccompose.ui.theme.DynamicComposeTheme
import com.nuzharukiya.dynamiccompose.ui.utils.ViewFactory
import com.nuzharukiya.dynamiccompose.utils.DataProvider

class ComplexPositionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchData()
        }
    }
}

@Composable
private fun FetchData() {
    val list = DataProvider().getData()

    ComplexLayout(list.toList())
}

@Composable
fun ComplexLayout(list: List<Compose>) {
    DynamicComposeTheme {
        Column(
            Modifier
                .padding(16.dp)
        ) {
            ConstraintLayout(
                decoupledConstraints(list),
                Modifier
                    .weight(1f)
            ) {
                list.forEach {
                    ViewFactory.makeView(it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComplexPreview() {
    DynamicComposeTheme {
        FetchData()
    }
}