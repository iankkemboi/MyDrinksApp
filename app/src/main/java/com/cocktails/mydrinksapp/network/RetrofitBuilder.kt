package com.cocktails.mydrinksapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    private fun getRetrofit(): Retrofit {

        val logging = HttpLoggingInterceptor()
// set your desired log level
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        //  final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(logging)

        val OkHttpClient = builder.connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient)
            .build() //Doesn't require the adapter
    }

    val apiService: DrinksApi = getRetrofit().create(DrinksApi::class.java)
}