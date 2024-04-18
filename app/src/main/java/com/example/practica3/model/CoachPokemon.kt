package com.example.practica3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coachs")
data class Coachs(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "pokemones")
    val pokemones:Int,
    @ColumnInfo(name = "medalla")
    val medalla: Boolean,
    @ColumnInfo(name = "batallas")
    val batallas: Float
)
