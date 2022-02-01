package com.example.movielistapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movielistapp.data.MainRepository
import com.example.movielistapp.model.Model
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<Model.Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {

        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<Model.Movie>> {
            override fun onResponse(call: Call<List<Model.Movie>>, response: Response<List<Model.Movie>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Model.Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}