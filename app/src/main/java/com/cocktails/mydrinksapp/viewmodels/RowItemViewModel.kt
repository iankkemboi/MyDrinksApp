package com.cocktails.mydrinksapp.viewmodels

import android.R
import android.content.Context
import android.content.res.ColorStateList
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cocktails.mydrinksapp.model.DrinksItem


class RowItemViewModel: ViewModel() {
    private val thumbnail = MutableLiveData<String>()
    private val title = MutableLiveData<String>()


    fun bind(child: DrinksItem){
        thumbnail.value = child.strDrinkThumb
        title.value = child.strDrink

    }

    fun getThumbnail():MutableLiveData<String>{
        return thumbnail
    }

    fun getTitle():MutableLiveData<String>{
        return title
    }

}