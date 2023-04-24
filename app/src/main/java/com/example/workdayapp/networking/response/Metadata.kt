package com.example.workdayapp.networking.response


import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("total_hits")
    val totalHits: Int? = null
)
