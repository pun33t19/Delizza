package com.example.delizza.model

import com.squareup.moshi.Json

data class PizzaItem(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "isVeg") val isVeg: Boolean,
    @Json(name = "description") val description: String,
    @Json(name = "defaultCrust") val defaultCrust: Int,
    @Json(name = "crusts") val crusts: List<CrustItems>
)
