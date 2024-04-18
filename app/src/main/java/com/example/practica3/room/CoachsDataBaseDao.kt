package com.example.practica3.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.practica3.model.Coachs
import kotlinx.coroutines.flow.Flow


@Dao
interface CoachsDataBaseDao {
    @Query("SELECT * FROM coachs")
    fun getCoachs(): Flow<List<Coachs>>
    @Query("SELECT * FROM coachs Where id=:id")
    fun getCoachsById(id:Long): Flow<Coachs>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(coach:Coachs)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(coach: Coachs)
    @Delete
    suspend fun delete(coach: Coachs)

}