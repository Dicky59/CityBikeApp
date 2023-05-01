package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class StationRequest(
    val nimi: String,
    val osoite: String
)
