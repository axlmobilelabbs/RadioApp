package com.example.radiostations.model

import com.google.gson.annotations.SerializedName

data class BaseModel (

      @SerializedName("items") val items : List<Items>

)