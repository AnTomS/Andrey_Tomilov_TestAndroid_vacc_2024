package com.atom.andreytomilovtestandroidvacc2024.domain.dto

import com.google.gson.annotations.SerializedName

data class Coffee(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val price: Double,
    @SerializedName("cup_volume")
    val cupVolume: Int
)
