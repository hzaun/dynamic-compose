package com.nuzharukiya.dynamiccompose.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParentView()
        }
    }

    @Composable
    fun ParentView() {
        MaterialTheme {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                OptionsLayout()
            }
        }
    }

    @Composable
    fun OptionsLayout() {
        Column(
            Modifier.padding(16.dp)
        ) {
            Button(
                onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            ComplexPositionActivity::class.java
                        )
                    )
                },
                modifier = Modifier
                    .layoutId("button2")
                    .padding(4.dp)
            ) {
                Text("Complex Pos")
            }
            Button(
                onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            UiActivity::class.java
                        )
                    )
                },
                modifier = Modifier
                    .layoutId("button3")
                    .padding(4.dp)
            ) {
                Text("Ui Options")
            }
            Button(
                onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            PositionActivity::class.java
                        )
                    )
                },
                modifier = Modifier
                    .layoutId("button1")
                    .padding(4.dp)
            ) {
                Text("Test Positions")
            }
        }
    }

    @Preview
    @Composable
    fun OptionsPreview() {
        OptionsLayout()
    }
}