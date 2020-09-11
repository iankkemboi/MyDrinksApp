package com.cocktails.mydrinksapp.repo

import com.cocktails.mydrinksapp.network.DrinksApi

class DrinksRepo(private val apiService: DrinksApi) {

    suspend fun getDrink(category: String) = apiService.filterbycategory(category)
}