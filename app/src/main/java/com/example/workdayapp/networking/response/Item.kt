package com.example.workdayapp.networking.response


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("data")
    val `data`: List<Data>? = null,
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("links")
    val links: List<Link>? = null
)
