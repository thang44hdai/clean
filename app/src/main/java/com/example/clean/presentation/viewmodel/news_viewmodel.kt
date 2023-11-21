package com.example.clean.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clean.data.api.news
import com.example.clean.domain.usecase.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class news_viewmodel : ViewModel() {
    val data_live: MutableLiveData<news> = MutableLiveData()
    fun get_data(): MutableLiveData<news> {
        apiService.api.getNews().enqueue(object : Callback<news> {
            override fun onResponse(call: Call<news>, response: Response<news>) {
                data_live.postValue(response.body())
            }
            override fun onFailure(call: Call<news>, t: Throwable) {
                Log.e("View Model", "Call Error")
            }
        })
        return data_live
    }


}