package com.example.pract3xam.Repository

import androidx.annotation.WorkerThread
import com.example.pract3xam.Prueba.Prueba
import com.example.pract3xam.Prueba.PruebaDAO
import kotlinx.coroutines.flow.Flow

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class PruebaRepository(private val pruebaDAO: PruebaDAO) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allPruebaKardex: Flow<List<Prueba>> = pruebaDAO.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(prueba: Prueba) {
        pruebaDAO.insertAll(prueba)
    }
    //agregado mio ***
    @WorkerThread
    suspend fun getPruebaById(id: Int): Prueba? {
        return pruebaDAO.getPruebaById(id)
    }
}