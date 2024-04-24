package com.example.pract3xam.Database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pract3xam.Prueba.Prueba
import com.example.pract3xam.Prueba.PruebaDAO

@Database(entities = [Prueba::class], version = 1)
abstract class PruebaDatabase : RoomDatabase() {
    abstract fun materiaDAO(): PruebaDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PruebaDatabase? = null

        fun getDatabase(context: Context): PruebaDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            //ponerle un valor a instance y si ya tiene regresarlo
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PruebaDatabase::class.java,
                    "prueba_database"//cambiar si es otra
                ).build()
                INSTANCE = instance
                // return instance
                instance
                //la ultima linea es lo que regresa
                //si pongo un "" me marcara error porque no retornar string
            }
        }//->
        //se asegura que fuera un unico hilo
    }
}