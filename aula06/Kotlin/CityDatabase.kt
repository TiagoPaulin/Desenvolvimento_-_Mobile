package com.example.aula06

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [City::class], version = 1)  // definindo como classe de banco de dados e as entidades do banco
abstract class CityDatabase : RoomDatabase() {

    // retorna um cityDao com o s métodos de interação com o banco
    abstract fun cityDao() : CityDao

    // retorna a instância do banco de dados
    companion object {
        private var instance: CityDatabase? = null
        fun getInstance(context: Context): CityDatabase? {
            if (instance == null) { // so cria uma nova instância se não houver nenhum
                synchronized(CityDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CityDatabase::class.java,
                        "cities.sqlite"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance
        }
    }
}