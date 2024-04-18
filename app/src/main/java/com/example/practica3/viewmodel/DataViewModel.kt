package com.example.practica3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica3.model.Coachs
import com.example.practica3.repository.CoachsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val repository: CoachsRepository): ViewModel() {
        private val _coachList = MutableStateFlow<List<Coachs>>(emptyList())
    val coachlist = _coachList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllcoachs().collect(){
                item ->
                if (item.isNullOrEmpty()){
                    _coachList.value= emptyList()
                }else{
                    _coachList.value = item
                }
            }
        }
    }
    fun addCoach(coach: Coachs) = viewModelScope.launch { repository.addCoach(coach) }
    fun updateCoach(coach: Coachs) = viewModelScope.launch { repository.updateCoach(coach) }
    fun deleteCoach(coach: Coachs) = viewModelScope.launch { repository.deleteCoach(coach) }
}