package com.example.workdayapp.networking.response


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("collection")
    val collection: Collection? = null
)
