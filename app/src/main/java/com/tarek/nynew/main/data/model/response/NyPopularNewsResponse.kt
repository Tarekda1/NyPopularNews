package com.tarek.nynew.main.data.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.tarek.nynew.main.data.model.NewsResponseModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NyPopularNewsResponse (

    @SerializedName("num_results")
    var numResults: Int = 0,

    @SerializedName("copyright")
    var copyright: String? = null,

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("results")
    var results: List<NewsResponseModel>? = null

): Parcelable

