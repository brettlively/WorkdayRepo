package com.example.workdayapp.networking.response


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("center")
    val center: String? = null,
    @SerializedName("date_created")
    val dateCreated: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("description_508")
    val description508: String? = null,
    @SerializedName("keywords")
    val keywords: List<String>? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("media_type")
    val mediaType: String? = null,
    @SerializedName("nasa_id")
    val nasaId: String? = null,
    @SerializedName("photographer")
    val photographer: String? = null,
    @SerializedName("secondary_creator")
    val secondaryCreator: String? = null,
    @SerializedName("title")
    val title: String? = null
)
