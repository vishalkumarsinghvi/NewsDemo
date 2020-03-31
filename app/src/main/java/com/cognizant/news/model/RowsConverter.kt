package com.cognizant.news.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type


class RowsConverter : Serializable {
    @TypeConverter // note this annotation
    fun fromRowsArrayList(Rows: ArrayList<Rows?>?): String? {
        if (Rows == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<ArrayList<Rows?>?>() {}.type
        return gson.toJson(Rows, type)
    }

    @TypeConverter // note this annotation
    fun toRowsArrayList(RowsString: String?): ArrayList<Rows>? {
        if (RowsString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<ArrayList<Rows?>?>() {}.type
        return gson.fromJson<ArrayList<Rows>>(RowsString, type)
    }
}