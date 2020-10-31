package com.tarek.nynew.main.data.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsMetaData (
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("format")
    var format: String? = null,
    @SerializedName("width")
    var width: String? = null,
    @SerializedName("height")
    var height: String? = null
): Parcelable