package com.example.practica3.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practica3.model.Coachs

@Database(entities = [Coachs::class], version = 1, exportSchema = false)
abstract class CoachsDataBase:RoomDatabase() {
    abstract fun coachsDao():CoachsDataBaseDao
}