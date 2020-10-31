package com.tarek.nynew.main.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.tarek.nynew.main.data.model.response.NewsMedia
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsResponseModel(

    @SerializedName("id")
    var id: Long = 0,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("source")
    var source: String? = null,

    @SerializedName("published_date")
    var publishedDate: String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("abstract")
    var abstract: String? = null,

    @SerializedName("media")
    var media: List<NewsMedia>? = null
) : Parcelable
