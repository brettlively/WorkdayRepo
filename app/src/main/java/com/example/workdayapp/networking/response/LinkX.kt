package com.example.workdayapp.networking.response


import com.google.gson.annotations.SerializedName

data class LinkX(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("prompt")
    val prompt: String? = null,
    @SerializedName("rel")
    val rel: String? = null
)
