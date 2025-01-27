package com.ferbajoo.templetecleanapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class NewsModelResponse(
    @SerializedName("status") var status: String? = null,
    @SerializedName("totalResults") var totalResults: Int? = null,
    @SerializedName("articles") var articles: List<ArticlesResponse>
)