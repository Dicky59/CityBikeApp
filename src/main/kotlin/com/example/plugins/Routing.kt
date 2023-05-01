package com.example.plugins

import com.example.models.ErrorResponse
import com.example.models.Station
import com.example.models.StationResponse
import com.example.services.StationService
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

private fun Station?.toStationResponse(): StationResponse? =
    this?.let { StationResponse(it.fid, it.id, it.nimi, it.osoite) }

fun Application.configureRouting() {
    routing {
        route("/stations") {
            val stationService = StationService()
            getAllStationsRoute(stationService)
            getStationByIdRoute(stationService)
        }
    }
}

fun Route.getAllStationsRoute(stationService: StationService) {
    get {
        val stations = stationService.findAllStations()
            .map(Station::toStationResponse)

        call.respond(message = stations)
    }
}

fun Route.getStationByIdRoute(bookService: StationService) {
    get("/{id}") {
        val id: Int = call.parameters["id"]?.toIntOrNull()
            ?: return@get call.respond(HttpStatusCode.BadRequest, ErrorResponse("Invalid id"))

        bookService.findStationById(id)
            ?.let { foundStation -> foundStation.toStationResponse() }
            ?.let { response -> call.respond(response) }
            ?: return@get call.respond(HttpStatusCode.BadRequest, ErrorResponse("Station with id [$id] not found"))
    }
}

