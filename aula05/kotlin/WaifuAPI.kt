package com.example.aula04

import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET

interface WaifuAPI {
    @GET("search")
    suspend fun getRandomWaifu() : ResponseBody //Funcao assíncrona
}