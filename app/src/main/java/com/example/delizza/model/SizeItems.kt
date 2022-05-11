package com.example.delizza.model

import com.squareup.moshi.Json

data class SizeItems(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "price") val price: Int
)