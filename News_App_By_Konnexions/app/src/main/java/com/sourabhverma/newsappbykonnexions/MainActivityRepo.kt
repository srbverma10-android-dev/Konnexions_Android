package com.sourabhverma.newsappbykonnexions

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityRepo {
    private val TAG = "MainActivity"

    fun getData(onResult: (NewsData?) -> Unit){
        APIHelper().getAllNews("India", "2021-12-13", "publishedAt", "a053f8eca2ec438a9779af3b0bccf92d")
            .enqueue(object : Callback<NewsData>{
                override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                    Log.d(TAG, "onResponse: ${response.body()!!.totalResults}")
                    val newsData : NewsData? = response.body()
                    onResult(newsData)
                }

                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    Log.d(TAG, "onFailure: $t")
                    onResult(null)
                }

            })
    }

}