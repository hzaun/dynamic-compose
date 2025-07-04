package com.nuzharukiya.dynamiccompose.utils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type


class DpAdapter : JsonDeserializer<Dp>, JsonSerializer<Dp> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Dp {
        return when {
            json == null -> 0.dp
            json.isJsonPrimitive && json.asJsonPrimitive.isNumber -> json.asFloat.dp
            json.isJsonPrimitive && json.asJsonPrimitive.isString -> {
                val raw = json.asString.trim().replace("dp", "").toFloatOrNull() ?: 0f
                raw.dp
            }
            else -> 0.dp
        }
    }

    override fun serialize(
        src: Dp?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive("${src?.value ?: 0f}dp")
    }
}
