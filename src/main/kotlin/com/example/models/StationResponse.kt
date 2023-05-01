package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class StationResponse(
    val fid: Int,
    val id: Int,
    val nimi: String,
    val osoite: String
)
