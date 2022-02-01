package com.example.movielistapp

import com.example.movielistapp.model.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
     @GET("movielist.json")
     fun getAllMoves() : Call<List<Model.Movie>>
     companion object{
         var retrofitService: RetrofitService? = null

         fun getInstance() : RetrofitService {
             if (retrofitService == null){
                 val retrofit = Retrofit.Builder()
                     .baseUrl("https://google.com")
                     .addConverterFactory(GsonConverterFactory.create())
                     .build()
                 retrofitService = retrofit.create(RetrofitService::class.java)
             }
             return retrofitService!!
         }
     }
}