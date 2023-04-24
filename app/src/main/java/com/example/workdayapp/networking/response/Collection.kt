package com.example.workdayapp.networking.response


import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("items")
    val items: List<Item>? = null,
    @SerializedName("links")
    val links: List<LinkX>? = null,
    @SerializedName("metadata")
    val metadata: Metadata? = null,
    @SerializedName("version")
    val version: String? = null
)
