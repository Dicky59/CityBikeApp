package com.example.models

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.double
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Station : Entity<Station> {
    companion object : Entity.Factory<Station>()

    val fid: Int
    val id: Int
    val nimi: String
    val namn: String
    val name: String
    val osoite: String
    val adress: String
    val kaupunki: String
    val stad: String
    val operaattori: String
    val kapasiteetti: Int
    val x: Double
    val y: Double
}

object Stations : Table<Station>("stations") {
    val fid = int("fid").bindTo(Station::fid)
    val id = int("id").bindTo(Station::id)
    val nimi = varchar("nimi").bindTo(Station::nimi)
    val namn = varchar("namn").bindTo(Station::namn)
    val name = varchar("name").bindTo(Station::name)
    val osoite = varchar("osoite").bindTo(Station::osoite)
    val adress = varchar("adress").bindTo(Station::adress)
    val kaupunki = varchar("kaupunki").bindTo(Station::kaupunki)
    val stad = varchar("stad").bindTo(Station::stad)
    val operaattori = varchar("operaattori").bindTo(Station::operaattori)
    val kapasiteetti = int("kapasiteetti").bindTo(Station::kapasiteetti)
    val x = double("x").bindTo(Station::x)
    val y = double("y").bindTo(Station::y)
}