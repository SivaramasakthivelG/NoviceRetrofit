package com.example.retrofitexample.mappers

import com.example.retrofitexample.Albums
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("/products")
    suspend fun getAlbumData(
        @Query("price")price:Double
    ): Response<Albums>

}