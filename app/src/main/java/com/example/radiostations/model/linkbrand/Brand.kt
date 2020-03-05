package com.example.radiostations.model.linkbrand

import com.google.gson.annotations.SerializedName

data class Brand (

    @SerializedName("rel") val rel : String,
    @SerializedName("href") val href : String,
    @SerializedName("content-type") val contentType : String

)