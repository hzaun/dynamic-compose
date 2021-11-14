package com.nuzharukiya.dynamiccompose.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.nuzharukiya.dynamiccompose.model.ALIGNMENT
import com.nuzharukiya.dynamiccompose.model.TYPOGRAPHY

/**
 * @author Nuzha Rukiya <r.nuzha@gmail.com>
 * @version $Revision 1.0 $, $Date 2021/04/29 20:10 $
 * @since
 *
 * Developed for Dynamic Compose
 */
class ViewUtils {
    fun getTextAlignment(alignment: ALIGNMENT?): TextAlign? {
        return when (alignment) {
            ALIGNMENT.START -> {
                TextAlign.Start
            }
            else -> {
                null
            }
        }
    }

    @Composable
    fun getTypography(typography: TYPOGRAPHY?): TextStyle {
        return when(typography) {
            TYPOGRAPHY.TITLE -> MaterialTheme.typography.h3
            TYPOGRAPHY.BUTTON -> MaterialTheme.typography.button
            TYPOGRAPHY.SUBTITLE1 -> MaterialTheme.typography.subtitle1
            else -> MaterialTheme.typography.subtitle2
        }
    }
}