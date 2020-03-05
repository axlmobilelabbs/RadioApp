package com.example.radiostations.model

import com.example.radiostations.model.linkbrand.Brand
import com.google.gson.annotations.SerializedName

data class Links (

    @SerializedName("brand") val brand : List<Brand>

)