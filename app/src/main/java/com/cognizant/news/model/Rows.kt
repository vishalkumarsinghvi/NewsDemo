package com.cognizant.news.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

//rows pojo
class Rows : Serializable {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "imageHref")
    @SerializedName("imageHref")
    var imageHref: String? = null

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String? = null

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String? = null
}
