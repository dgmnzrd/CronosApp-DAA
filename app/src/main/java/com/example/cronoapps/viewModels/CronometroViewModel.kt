package com.example.cronoapps.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cronoapps.state.CronoState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CronometroViewModel:ViewModel() {
    var state by mutableStateOf(CronoState())
        private set
    private var cronoJob by mutableStateOf<Job?>(null)
    var tiempo by mutableLongStateOf(0L)
    fun onValue(value: String){
        state = state.copy(
            title = value
        )
    }

    fun iniciar(){
        state = state.copy(
            cronometroActivo = true
        )
    }

    fun pausar(){
        state = state.copy(
            cronometroActivo = false,
            showSaveButton = true
        )
    }

    fun detener(){
        cronoJob?.cancel()
        tiempo=0
        state = state.copy(
            cronometroActivo = false,
            showSaveButton = false,
            showTextField = false
        )
    }

    fun showTextField(){
        state = state.copy(
            showTextField = true
        )
    }

    fun cronos(){
        if(state.cronometroActivo){
            cronoJob?.cancel()
            cronoJob = viewModelScope.launch {
                while(true){
                    delay(1000)
                    tiempo += 1000
                }
            }
        }else{
            cronoJob?.cancel()
        }
    }

}