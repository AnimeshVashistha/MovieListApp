package com.example.movielistapp.data

import com.example.movielistapp.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService){

    fun getAllMovies() = retrofitService.getAllMovies()
}