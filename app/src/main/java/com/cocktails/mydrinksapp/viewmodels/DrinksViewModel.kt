package com.cocktails.mydrinksapp.viewmodels

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cocktails.mydrinksapp.repo.DrinksRepo
import com.cocktails.mydrinksapp.utils.ResourceStatus
import kotlinx.coroutines.Dispatchers


class DrinksViewModel(private val drinksrepo: DrinksRepo) : ViewModel() {

    fun getCocktails(category: String) = liveData(Dispatchers.IO) {
        emit(ResourceStatus.loading(data = null))
        try {
            emit(ResourceStatus.success(data = drinksrepo.getDrink(category)))
        } catch (exception: Exception) {
            emit(ResourceStatus.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    companion object {


        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadimage(imageView: ImageView, imageUrl: String?) {
            if (!imageUrl.isNullOrEmpty()) {

                Glide.with(imageView.context).load(imageUrl)
                    .apply(RequestOptions.centerCropTransform())
                    .into(imageView)

            }
        }


    }
    }