package com.tarek.nynew.main.data.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsMedia(

    @SerializedName("type")
    var title: String? = null,

    @SerializedName("caption")
    var caption: String? = null,

    @SerializedName("copyright")
    var copyright: String? = null,

    @SerializedName("media-metadata")
    var mediaMetaData: List<NewsMetaData>? = null

) : Parcelable
