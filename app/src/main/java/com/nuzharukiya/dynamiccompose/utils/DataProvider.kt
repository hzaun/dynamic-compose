package com.nuzharukiya.dynamiccompose.utils

import android.content.Context
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.nuzharukiya.dynamiccompose.model.*
import com.nuzharukiya.dynamiccompose.ui.helpers.ViewHelper

/**
 * @author Nuzha Rukiya <r.nuzha@gmail.com>
 * @version $Revision 1.0 $, $Date 2021/05/03 19:21 $
 * @since
 *
 * Developed for Dynamic Compose
 */
class DataProvider {

    fun getData(context: Context, assetPath: String): List<Compose> {
        val json = context.assets.open(assetPath).bufferedReader().use { it.readText() }
        val gson = GsonBuilder()
            .registerTypeAdapter(Dp::class.java, DpAdapter())
            .create()

        val type = object : TypeToken<List<RawDataModel>>() {}.type
        val viewDataList: List<RawDataModel> = gson.fromJson(json, type)

        return convertRawDataToComposeList(viewDataList)
    }

    private fun convertRawDataToComposeList(viewDataList: List<RawDataModel>): MutableList<Compose> {
        val composeData = mutableListOf<Compose>()
        viewDataList.forEach { rawData ->
            convertRawDataToCompose(rawData)?.let {
                composeData.add(
                    it
                )
            }
        }
        return composeData
    }

    private fun convertRawDataToCompose(rawData: RawDataModel?): Compose? {
        if (rawData == null) return null

        val children = rawData.children?.let {
            convertRawDataToComposeList(it)
        }

        return ViewHelper.values(
            metaDataId = rawData.id,
            dataId = rawData.name,
            text = rawData.text,
            typography = rawData.typography,
            padding = rawData.padding,
            backgroundColor = rawData.backgroundColor ?: "#ffffff",
            textColor = rawData.textColor ?: "#000000",
            viewType = rawData.viewType,
            action = rawData.action,
            constraintLinks = getCLink(rawData),
            children = children,
        )
    }

    private fun getCLink(rawData: RawDataModel) =
        ConstraintLink(
            left = rawData.constraintLinks.left?.let { getLink(it) },
            top = rawData.constraintLinks.top?.let { getLink(it) },
            right = rawData.constraintLinks.right?.let { getLink(it) },
            bottom = rawData.constraintLinks.bottom?.let { getLink(it) },
        )

    private fun getLink(rawLink: RawLink) =
        Link(
            item = rawLink.target,
            constraint = CONSTRAINT_OPTIONS.valueOf(rawLink.anchor),
            margin = rawLink.margin.dp
        )
}