package com.example.services

import com.example.models.Station
import com.example.models.Stations
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toSet

class StationService {
    private val database = Database.connect(
        url = "jdbc:postgresql://localhost:5432/citybike",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "omaha"
    )

    fun findAllStations(): Set<Station> =
        database.sequenceOf(Stations).toSet()

    fun findStationById(stationId: Int): Station? =
        database.sequenceOf(Stations)
            .find { station -> station.id eq stationId }
}