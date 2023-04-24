package com.example.workdayapp.networking.response


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("rel")
    val rel: String? = null,
    @SerializedName("render")
    val render: String? = null
)
