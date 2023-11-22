package com.example.clean.domain.usecase

import com.example.clean.data.api.news
import com.example.clean.data.constants.constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface apiService {
    companion object{
        val api: apiService = Retrofit.Builder()
            .baseUrl(constants.domain)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiService::class.java)
    }
    @GET("everything")
    fun getNews(@Query("domains") domain: String, @Query("apiKey") apiKey: String): Call<news>
}