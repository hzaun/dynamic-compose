package com.nuzharukiya.dynamiccompose.utils

import androidx.compose.ui.graphics.Color

/**
 * @author Nuzha Rukiya <r.nuzha@gmail.com>
 * @version $Revision 1.0 $, $Date 2021/04/29 20:07 $
 * @since
 *
 * Developed for Dynamic Compose
 */
class ColorUtils {
    fun stringToColor(colorString: String): Color {
        return Color(
            android.graphics.Color.parseColor(
                colorString
            )
        )
    }
}