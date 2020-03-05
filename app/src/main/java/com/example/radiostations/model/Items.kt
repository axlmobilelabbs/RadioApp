package com.example.radiostations.model

import com.google.gson.annotations.SerializedName

data class Items (

      @SerializedName("attributes") val attributes : Attributes,
      @SerializedName("links") val links : Links

)