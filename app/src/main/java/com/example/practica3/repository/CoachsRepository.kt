package com.example.practica3.repository

import com.example.practica3.model.Coachs
import com.example.practica3.room.CoachsDataBaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CoachsRepository @Inject constructor(private val coachsDataBaseDao: CoachsDataBaseDao){
    suspend fun addCoach(coach : Coachs) = coachsDataBaseDao.insert(coach)
    suspend fun updateCoach(coach : Coachs) = coachsDataBaseDao.update(coach)
    suspend fun deleteCoach(coach : Coachs) = coachsDataBaseDao.delete(coach)

    fun getAllcoachs(): Flow<List<Coachs>> = coachsDataBaseDao
        .getCoachs()
        .flowOn(Dispatchers.IO)
        .conflate()

    fun getCoachByID(id:Long): Flow<Coachs> = coachsDataBaseDao
        .getCoachsById(id)
        .flowOn(Dispatchers.IO)
        .conflate()
}