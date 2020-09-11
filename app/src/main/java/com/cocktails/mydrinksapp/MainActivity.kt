package com.cocktails.mydrinksapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.cocktails.mydrinksapp.adapter.DrinksAdapter
import com.cocktails.mydrinksapp.model.DrinksItem
import com.cocktails.mydrinksapp.network.RetrofitBuilder
import com.cocktails.mydrinksapp.utils.StateStatus
import com.cocktails.mydrinksapp.viewmodels.DrinksViewModel
import com.cocktails.mydrinksapp.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DrinksViewModel
    private lateinit var adapter: DrinksAdapter
    private val  category = "Alcoholic"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(RetrofitBuilder.apiService)
        ).get(DrinksViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
  }

    private fun setupObservers() {
        viewModel.getCocktails(category).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    StateStatus.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { lstdrinks

                            -> setList(lstdrinks.drinks)

                        }
                    }
                    StateStatus.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()

                    }
                    StateStatus.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun setList(listdr: List<DrinksItem>) {
        adapter = DrinksAdapter(listdr)
        recyclerView.adapter = adapter

    }
}