package com.example.pract3xam.Application

import android.app.Application
import com.example.pract3xam.Database.PruebaDatabase
import com.example.pract3xam.Repository.PruebaRepository


class PruebaApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { PruebaDatabase.getDatabase(this) }
    val repository by lazy { PruebaRepository(database.materiaDAO()) }
}