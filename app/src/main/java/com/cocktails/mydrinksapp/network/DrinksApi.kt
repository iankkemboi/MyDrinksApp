package com.cocktails.mydrinksapp.network

import com.cocktails.mydrinksapp.model.DrinksModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksApi {

    @GET("filter.php?")
    suspend fun filterbycategory(@Query("a") c: String?): DrinksModel
}