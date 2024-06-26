package com.example.pract3xam.Prueba

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PruebaDAO {
    @Query("SELECT * FROM Prueba")
    fun getAll(): Flow<List<Prueba>>

    @Query("SELECT * FROM Prueba WHERE ID = :id")
    suspend fun getPruebaById(id: Int): Prueba?

    @Query("DELETE FROM Prueba WHERE ID = :id")
    suspend fun deletePruebaById(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg m : Prueba)

    @Update
    fun update(m: Prueba)
}