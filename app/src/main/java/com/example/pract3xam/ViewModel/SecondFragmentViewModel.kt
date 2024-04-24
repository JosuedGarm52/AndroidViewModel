package com.example.pract3xam.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pract3xam.Prueba.Prueba
import com.example.pract3xam.Repository.PruebaRepository
import kotlinx.coroutines.launch

class SecondFragmentViewModel (private val repository: PruebaRepository): ViewModel() {

    fun insertMateria(materia: Prueba) = viewModelScope.launch{
        repository.insert(materia)
    }
}

class SecondFragmentViewModelFactory(private val repository: PruebaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SecondFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SecondFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}