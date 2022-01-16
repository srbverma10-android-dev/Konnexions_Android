package com.sourabhverma.newsappbykonnexions

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIHelper {
    @GET("everything")
    fun getAllNews(@Query("q") q : String,
                    @Query("from") from : String,
                    @Query("sortBy") sortBy : String,
                    @Query("apiKey") apiKey : String) : Call<NewsData>


    companion object{
        operator fun invoke() : APIHelper {
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIHelper::class.java)
        }
    }
}