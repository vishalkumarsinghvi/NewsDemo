package com.cognizant.news.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
class NewsArticles : Serializable {

    @PrimaryKey
    var uid: Int = 0

    @ColumnInfo(name = "first_name")
    @SerializedName("title")
    var title: String? = ""

    @TypeConverters(RowsConverter::class)
    @ColumnInfo(name = "rows")
    @SerializedName("rows")
    var rows: List<Rows>?= emptyList<Rows>()

}
