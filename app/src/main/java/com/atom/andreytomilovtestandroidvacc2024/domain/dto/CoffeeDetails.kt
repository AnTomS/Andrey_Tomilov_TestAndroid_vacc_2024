package com.atom.andreytomilovtestandroidvacc2024.domain.dto

import com.google.gson.annotations.SerializedName

data class CoffeeDetails(
    val id: Int,
    val name: String,
    val description: String,
    @SerializedName("image_uri")
    val imageUri: String,
    val price: Double,
    val portionMl: Int
)
