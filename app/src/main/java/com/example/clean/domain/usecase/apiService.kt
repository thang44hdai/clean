package com.example.clean.domain.usecase

import com.example.clean.data.api.news
import com.example.clean.data.constants.constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface apiService {
    companion object{
        val api: apiService = Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiService::class.java)
    }
    @GET("/v2/everything?q=Apple&from=2023-11-21&sortBy=popularity&apiKey=b57bf1ebd5f04ad58934ab3ba6316401")
    fun getNews(): Call<news>
}