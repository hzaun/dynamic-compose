package com.nuzharukiya.dynamiccompose.ui.utils

import android.util.Log
import com.nuzharukiya.dynamiccompose.model.Compose

/**
 * @author Nuzha Rukiya <r.nuzha@gmail.com>
 * @version $Revision 1.0 $, $Date 2021/04/29 15:37 $
 * @since
 *
 * Developed for Dynamic Compose
 */
object ActionFactory {
    fun execute(compose: Compose) {
        compose.metaData.action?.let {
            when (it) {
                ACTION_TYPE.NAVIGATE -> {
                    Log.d(this.javaClass.simpleName, "Navigate Button Pressed")
                }
            }
        }
    }
}

enum class ACTION_TYPE {
    NAVIGATE
}