package com.example.aula06

import android.content.Context

object Singleton {
    // Lista de cidades
    lateinit var cities: List<City>
    // DAO para acesso ao banco de dados
    private lateinit var dao: CityDao
    // Referência para a cidade selecionada
    var citySelected: City? = null

    // Método para configurar e inicializar o Singleton
    fun setContext(context: Context){
        // Obtém uma instância do banco de dados usando o contexto fornecido
        CityDatabase.getInstance(context)?.apply {
            // Inicializa o objeto dao com o DAO de cidade obtido da instância do banco de dados
            dao = cityDao()
            // Obtém todas as cidades do banco de dados e atribui à lista cities
            cities = dao.getAll()
        }
    }

    fun add(city: City){
        dao.insert(city)
        cities = dao.getAll()
    }
    fun update(city: City){
        dao.update(city)
        cities = dao.getAll()
    }
    fun delete(city: City){
        dao.delete(city)
        cities = dao.getAll()
    }
}

