package com.example.retrofitexample

import com.example.retrofitexample.utils.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {

    companion object{

        const val BASE_URL = "https://fakestoreapi.com/"


        fun getInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory
                    .create())
                    .build()
        }
    }

}