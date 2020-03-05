package com.example.radiostations.model

import com.google.gson.annotations.SerializedName

data class Brand(

    @SerializedName("band") val band: String,
    @SerializedName("call") val call: String,
    @SerializedName("frequency") val frequency: String,
    @SerializedName("marketCity") val marketCity: String,
    @SerializedName("marketState") val marketState: String,
    @SerializedName("name") val name: String,
    @SerializedName("tagline") val tagline: String

)