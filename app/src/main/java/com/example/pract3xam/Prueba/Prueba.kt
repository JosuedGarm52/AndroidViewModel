package com.example.pract3xam.Prueba

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Prueba(
    @PrimaryKey @ColumnInfo(name = "ID") var ID: Int,
    var Cuerpo: String
)