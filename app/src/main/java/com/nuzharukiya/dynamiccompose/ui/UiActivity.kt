package com.nuzharukiya.dynamiccompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.nuzharukiya.dynamiccompose.R
import com.nuzharukiya.dynamiccompose.model.*
import com.nuzharukiya.dynamiccompose.ui.helpers.ViewHelper
import com.nuzharukiya.dynamiccompose.ui.theme.DynamicComposeTheme
import com.nuzharukiya.dynamiccompose.ui.utils.ViewFactory

class UiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParentView()
        }
    }

    @Composable
    fun ParentView() {
        MaterialTheme() {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Surface { TwoTexts(text1 = "Hello,", text2 = "World!") }
                DecoupledConstraintLayout()
                LargeConstraintLayout()
                ConstraintLayoutContent()
                Offer("XYZ")
                FlexibleComposable()
            }
        }
    }

    @Composable
    fun TwoTexts(modifier: Modifier = Modifier, text1: String, text2: String) {
        Row(modifier = modifier.height(IntrinsicSize.Min)) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
                    .wrapContentWidth(Alignment.Start),
                text = text1
            )

            Divider(
                color = Color.Black,
                modifier = Modifier
                    .height(36.dp)
                    .width(1.dp)
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp)
                    .wrapContentWidth(Alignment.End),
                text = text2
            )
        }
    }

    @Composable
    fun DecoupledConstraintLayout() {
        BoxWithConstraints(
            Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
        ) {
            val constraints = if (maxWidth < maxHeight) {
                decoupledConstraints(margin = 16.dp) // Portrait constraints
            } else {
                decoupledConstraints(margin = 32.dp) // Landscape constraints
            }

            ConstraintLayout(constraints) {
                Button(
                    onClick = { /* Do something */ },
                    modifier = Modifier.layoutId("button")
                ) {
                    Text("Button")
                }

                Text("Text", Modifier.layoutId("text"))
            }
        }
    }

    private fun decoupledConstraints(margin: Dp): ConstraintSet {
        return ConstraintSet {
            val button = createRefFor("button")
            val text = createRefFor("text")

            constrain(button) {
                top.linkTo(parent.top, margin = margin)
            }
            constrain(text) {
                top.linkTo(button.bottom, margin)
            }
        }
    }

    @Composable
    fun LargeConstraintLayout() {
        ConstraintLayout(
            Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
        ) {
            val text = createRef()

            val guideline = createGuidelineFromStart(fraction = 0.5f)
            Text(
                getString(R.string.jeffsum_1),
                Modifier.constrainAs(text) {
                    linkTo(start = guideline, end = parent.end)
                    width = Dimension.preferredWrapContent
                },
                color = Color.Green
            )
        }
    }

    @Composable
    fun ConstraintLayoutContent() {
        ConstraintLayout(
            Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
        ) {
            // Create references for the composables to constrain
            val (button1, button2, text) = createRefs()

            Button(
                onClick = { /* Do something */ },
                // Assign reference "button" to the Button composable
                // and constrain it to the top of the ConstraintLayout
                modifier = Modifier.constrainAs(button1) {
                    top.linkTo(parent.top, margin = 16.dp)
                }
            ) {
                Text("Button 1")
            }

            // Assign reference "text" to the Text composable
            // and constrain it to the bottom of the Button composable
            Text(
                "Text",
                Modifier.constrainAs(text) {
                    top.linkTo(button1.bottom, margin = 16.dp)
                    // Centers Text horizontally in the ConstraintLayout
                    centerHorizontallyTo(parent)
                },
                color = Color.Blue,
            )

            val barrier = createEndBarrier(button1, text)
            Button(
                onClick = { /* Do something */ },
                modifier = Modifier.constrainAs(button2) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(barrier)
                }
            ) {
                Text("Button 2")
            }
        }
    }

    @Composable
    fun test() {
        val b1 = ViewHelper.values(
            "b1",
            "Text 1",
            backgroundColor = "#d2acf5",
            textColor = "#ffffff",
            viewType = VIEW_TYPE.BUTTON,
            constraintLinks = ConstraintLink(
                left = Link("parent", CONSTRAINT_OPTIONS.LEFT),
                top = Link("parent", CONSTRAINT_OPTIONS.TOP)
            )
        )
        val b2 = ViewHelper.values(
            "b2",
            "Text 2",
            backgroundColor = "#0095ff",
            textColor = "#ffffff",
            viewType = VIEW_TYPE.BUTTON,
            constraintLinks = ConstraintLink(
                left = Link("b1", CONSTRAINT_OPTIONS.RIGHT),
                top = Link("b1", CONSTRAINT_OPTIONS.TOP)
            )
        )

        DynamicComposeTheme {
            BoxWithConstraints(
                Modifier.padding(16.dp)
            ) {
                ConstraintLayout(testDecoupledConstraints()) {
                    ViewFactory.makeView(b1)
                    ViewFactory.makeView(b2)
                }
            }
        }
    }

    private fun testDecoupledConstraints(): ConstraintSet {
        return ConstraintSet {
            val b1ref = createRefFor("b1")
            val b2ref = createRefFor("b2")

            constrain(b1ref) {
                top.linkTo(parent.top, margin = 16.dp)
            }
            constrain(b2ref) {
                top.linkTo(b1ref.bottom, margin = 16.dp)
            }
        }
    }

    @Composable
    fun Offer(text: String) {
        Box(
            Modifier
                .padding(0.dp, 16.dp, 0.dp, 0.dp)
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentHeight(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(7.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight()
                    .align(Alignment.Center)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Text(
                    text,
                    color = Color.Blue,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    "Bangalore, IN",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    getString(R.string.jeffsum_2),
                    style = MaterialTheme.typography.body2,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

    @Composable
    fun FlexibleComposable() {
        Column(
            Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(

                )
            ) {
                Box(
                    Modifier
                        .weight(2f)
                        .height(50.dp)
                        .background(Color.Blue)
                )
                Box(
                    Modifier
                        .weight(1f)
                        .height(50.dp)
                        .background(Color.Red)
                )
            }
            BoxWithConstraints {
                Text(
                    "My minHeight is $minHeight while my maxWidth is $maxWidth",
                    color = Color.Cyan
                )
            }
        }
    }

    @Preview
    @Composable
    fun PreviewTest() {
        test()
    }
}