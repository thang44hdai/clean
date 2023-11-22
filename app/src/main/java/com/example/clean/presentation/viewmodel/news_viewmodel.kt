package com.example.clean.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clean.data.api.Article
import com.example.clean.data.api.news
import com.example.clean.domain.usecase.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.reflect.typeOf

class news_viewmodel : ViewModel() {
    val _dataList: MutableLiveData<news> = MutableLiveData()

    fun get_data(): MutableLiveData<news> {
        apiService.api.getNews("techcrunch.com,thenextweb.com", "b57bf1ebd5f04ad58934ab3ba6316401").enqueue(object : Callback<news> {
            override fun onResponse(call: Call<news>, response: Response<news>) {
                val currentData = response.body()
                if(currentData!= null){
                    _dataList.postValue(currentData)
                    Log.i("View Model Access", "Call Access")
                }
            }
            override fun onFailure(call: Call<news>, t: Throwable) {
                Log.e("View Model", "Call Error")
            }
        })
        return _dataList
    }
}