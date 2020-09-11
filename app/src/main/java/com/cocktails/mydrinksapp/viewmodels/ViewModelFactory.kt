package com.cocktails.mydrinksapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cocktails.mydrinksapp.network.DrinksApi
import com.cocktails.mydrinksapp.repo.DrinksRepo


class ViewModelFactory(private val apiService: DrinksApi) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DrinksViewModel::class.java)) {
            return DrinksViewModel(DrinksRepo(apiService)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}