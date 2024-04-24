package com.example.pract3xam.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pract3xam.Prueba.Prueba
import com.example.pract3xam.Repository.PruebaRepository
import androidx.lifecycle.asLiveData

class FirstFragmentViewModel(private val repository: PruebaRepository) : ViewModel(){
    val pruebaKardex : LiveData<List<Prueba>> = repository.allPruebaKardex.asLiveData()
}
class FirstFragmentViewModelFactory(private val repository: PruebaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FirstFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FirstFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}