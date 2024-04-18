package com.example.practica3.viewmodel

import android.util.Log
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica3.repository.CoachsRepository
import com.example.practica3.state.CoachState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoachViewModel @Inject constructor(
    private val repository: CoachsRepository):ViewModel() {
        var state by mutableStateOf(CoachState())
            private set

    fun getCoachById(id:Long){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCoachByID(id).collect{
                item ->
                    if(item != null){
                        state=state.copy(nombre = item.nombre)
                        state=state.copy(pokemones = item.pokemones)
                        state=state.copy(medalla = item.medalla)
                        state=state.copy(batallas = item.batallas)
                    }else{
                        Log.d("Error","El objeto es nulo")
                    }
            }
        }
    }
    fun onValue (value: String){
        state=state.copy(nombre = value)
    }
}