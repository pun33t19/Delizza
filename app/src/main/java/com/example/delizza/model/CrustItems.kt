package com.example.delizza.model

import com.squareup.moshi.Json

data class CrustItems(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name="defaultSize") val defaultSize: Int,
    @Json(name="sizes") val sizes: List<SizeItems>
)
