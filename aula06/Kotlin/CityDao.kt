package com.example.aula06

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao // definindo interface de interação com o banco
interface CityDao {

    // metodos de interação com o banco

    @Insert
    fun insert(city : City)

    @Query("SELECT * FROM table_city")
    fun getAll() : List<City>

    @Query("SELECT * FROM table_city WHERE city_name = :name")
    fun getByName(name : String) : List<City>

    @Update
    fun update(city : City) : Int

    @Delete
    fun delete(city : City) : Int

}