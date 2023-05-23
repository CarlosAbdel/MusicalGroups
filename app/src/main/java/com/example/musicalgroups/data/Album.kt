package com.example.musicalgroups.data

import java.io.Serializable

data class Album(
    val titulo: String,
    val artista: String,
    val selloDiscografico: String,
    val añoLanzamiento: Int,
    val contadorReproducciones: Int,
    val caratula: String
) : Serializable

