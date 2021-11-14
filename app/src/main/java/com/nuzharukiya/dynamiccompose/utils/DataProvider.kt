package com.nuzharukiya.dynamiccompose.utils

import androidx.compose.ui.unit.dp
import com.nuzharukiya.dynamiccompose.model.*
import com.nuzharukiya.dynamiccompose.ui.helpers.ViewHelper
import com.nuzharukiya.dynamiccompose.ui.utils.ACTION_TYPE

/**
 * @author Nuzha Rukiya <r.nuzha@gmail.com>
 * @version $Revision 1.0 $, $Date 2021/05/03 19:21 $
 * @since
 *
 * Developed for Dynamic Compose
 */
class DataProvider {
    fun getData(): List<Compose> {
        return listOf(
            ViewHelper.values(
                "t1",
                "Text 1",
                text = "Title",
                typography = TYPOGRAPHY.TITLE,
                padding = 4,
                backgroundColor = "#d2acf5",
                textColor = "#ffffff",
                viewType = VIEW_TYPE.TEXT,
                constraintLinks = ConstraintLink(
                    left = Link("parent", CONSTRAINT_OPTIONS.LEFT),
                    top = Link("parent", CONSTRAINT_OPTIONS.TOP)
                )
            ),
            ViewHelper.values(
                "t2",
                "Text 2",
                text = "Subtitle",
                typography = TYPOGRAPHY.SUBTITLE1,
                padding = 4,
                backgroundColor = "#0095ff",
                textColor = "#ffffff",
                viewType = VIEW_TYPE.TEXT,
                constraintLinks = ConstraintLink(
                    left = Link("t1", CONSTRAINT_OPTIONS.LEFT, 16.dp),
                    top = Link("t1", CONSTRAINT_OPTIONS.BOTTOM)
                )
            ),
            ViewHelper.values(
                "t3",
                "Text 3",
                text = "Description: Lorem ipsum dolor sit amet",
                padding = 4,
                backgroundColor = "#837cec",
                textColor = "#ffffff",
                viewType = VIEW_TYPE.TEXT,
                constraintLinks = ConstraintLink(
                    left = Link("t2", CONSTRAINT_OPTIONS.LEFT, 16.dp),
                    top = Link("t2", CONSTRAINT_OPTIONS.BOTTOM)
                )
            ),
            ViewHelper.values(
                "b1",
                "Some Action",
                text = "Clicky",
                backgroundColor = "#49eec7",
                textColor = "#ffffff",
                viewType = VIEW_TYPE.BUTTON,
                action = ACTION_TYPE.NAVIGATE,
                constraintLinks = ConstraintLink(
                    top = Link("t2", CONSTRAINT_OPTIONS.TOP),
                    right = Link("parent", CONSTRAINT_OPTIONS.RIGHT, 16.dp),
                )
            ),
            ViewHelper.values(
                "b2",
                "Some Action",
                text = "!1!",
                backgroundColor = "#8a2a8e",
                textColor = "#ffffff",
                viewType = VIEW_TYPE.BUTTON,
                action = ACTION_TYPE.NAVIGATE,
                constraintLinks = ConstraintLink(
                    left = Link("parent", CONSTRAINT_OPTIONS.LEFT),
                    top = Link("t2", CONSTRAINT_OPTIONS.TOP),
                    right = Link("parent", CONSTRAINT_OPTIONS.RIGHT),
                )
            ),
            ViewHelper.values(
                "b3",
                "Some Action",
                text = "!2!",
                backgroundColor = "#038c81",
                textColor = "#ffffff",
                viewType = VIEW_TYPE.BUTTON,
                action = ACTION_TYPE.NAVIGATE,
                constraintLinks = ConstraintLink(
                    left = Link("parent", CONSTRAINT_OPTIONS.LEFT),
                    top = Link("parent", CONSTRAINT_OPTIONS.TOP),
                    right = Link("parent", CONSTRAINT_OPTIONS.RIGHT),
                )
            ),
            ViewHelper.values(
                "b4",
                "Some Action",
                text = "!3!",
                backgroundColor = "#adbadb",
                textColor = "#ffffff",
                viewType = VIEW_TYPE.BUTTON,
                action = ACTION_TYPE.NAVIGATE,
                constraintLinks = ConstraintLink(
                    left = Link("parent", CONSTRAINT_OPTIONS.LEFT),
                    top = Link("parent", CONSTRAINT_OPTIONS.TOP, 120.dp),
                    right = Link("parent", CONSTRAINT_OPTIONS.RIGHT),
                )
            ),
            ViewHelper.values(
                "l1",
                "Layout",
                backgroundColor = "#efefef",
                viewType = VIEW_TYPE.LAYOUT,
                action = ACTION_TYPE.NAVIGATE,
                constraintLinks = ConstraintLink(
                    left = Link("parent", CONSTRAINT_OPTIONS.LEFT),
                    top = Link("t3", CONSTRAINT_OPTIONS.BOTTOM, 16.dp),
                    right = Link("parent", CONSTRAINT_OPTIONS.RIGHT),
                    bottom = Link("parent", CONSTRAINT_OPTIONS.BOTTOM)
                ),
                children = listOf(
                    ViewHelper.values(
                        "t1",
                        "Text 1",
                        text = "Title",
                        typography = TYPOGRAPHY.TITLE,
                        padding = 4,
                        backgroundColor = "#d2acf5",
                        textColor = "#ffffff",
                        viewType = VIEW_TYPE.TEXT,
                        constraintLinks = ConstraintLink(
                            left = Link("parent", CONSTRAINT_OPTIONS.LEFT),
                            top = Link("parent", CONSTRAINT_OPTIONS.TOP)
                        )
                    ),
                    ViewHelper.values(
                        "t2",
                        "Text 2",
                        text = "Subtitle",
                        typography = TYPOGRAPHY.SUBTITLE1,
                        padding = 4,
                        backgroundColor = "#0095ff",
                        textColor = "#ffffff",
                        viewType = VIEW_TYPE.TEXT,
                        constraintLinks = ConstraintLink(
                            left = Link("t1", CONSTRAINT_OPTIONS.LEFT, 16.dp),
                            top = Link("t1", CONSTRAINT_OPTIONS.BOTTOM)
                        )
                    ),
                    ViewHelper.values(
                        "t3",
                        "Text 3",
                        text = "Description: Lorem ipsum dolor sit amet",
                        padding = 4,
                        backgroundColor = "#837cec",
                        textColor = "#ffffff",
                        viewType = VIEW_TYPE.TEXT,
                        constraintLinks = ConstraintLink(
                            left = Link("t2", CONSTRAINT_OPTIONS.LEFT, 16.dp),
                            top = Link("t2", CONSTRAINT_OPTIONS.BOTTOM)
                        )
                    ),
                    ViewHelper.values(
                        "l2",
                        "Layout",
                        backgroundColor = "#232323",
                        viewType = VIEW_TYPE.LAYOUT,
                        action = ACTION_TYPE.NAVIGATE,
                        constraintLinks = ConstraintLink(
                            left = Link("parent", CONSTRAINT_OPTIONS.LEFT),
                            top = Link("t3", CONSTRAINT_OPTIONS.BOTTOM, 16.dp),
                            right = Link("parent", CONSTRAINT_OPTIONS.RIGHT),
                            bottom = Link("parent", CONSTRAINT_OPTIONS.BOTTOM)
                        ),
                        children = listOf(
                            ViewHelper.values(
                                "t1",
                                "Text 1",
                                text = "Title",
                                typography = TYPOGRAPHY.TITLE,
                                padding = 4,
                                backgroundColor = "#d2acf5",
                                textColor = "#ffffff",
                                viewType = VIEW_TYPE.TEXT,
                                constraintLinks = ConstraintLink(
                                    left = Link("parent", CONSTRAINT_OPTIONS.LEFT),
                                    top = Link("parent", CONSTRAINT_OPTIONS.TOP)
                                )
                            ),
                            ViewHelper.values(
                                "t2",
                                "Text 2",
                                text = "Subtitle",
                                typography = TYPOGRAPHY.SUBTITLE1,
                                padding = 4,
                                backgroundColor = "#0095ff",
                                textColor = "#ffffff",
                                viewType = VIEW_TYPE.TEXT,
                                constraintLinks = ConstraintLink(
                                    left = Link("t1", CONSTRAINT_OPTIONS.LEFT, 16.dp),
                                    top = Link("t1", CONSTRAINT_OPTIONS.BOTTOM)
                                )
                            ),
                            ViewHelper.values(
                                "t3",
                                "Text 3",
                                text = "Description: Lorem ipsum dolor sit amet",
                                padding = 4,
                                backgroundColor = "#837cec",
                                textColor = "#ffffff",
                                viewType = VIEW_TYPE.TEXT,
                                constraintLinks = ConstraintLink(
                                    left = Link("t2", CONSTRAINT_OPTIONS.LEFT, 16.dp),
                                    top = Link("t2", CONSTRAINT_OPTIONS.BOTTOM)
                                )
                            ),
                        )
                    )
                )
            ),
        )
    }
}