package com.cocktails.mydrinksapp.adapter



import android.content.Context
import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cocktails.mydrinksapp.R
import com.cocktails.mydrinksapp.databinding.RowItemBinding
import com.cocktails.mydrinksapp.model.DrinksItem
import com.cocktails.mydrinksapp.viewmodels.RowItemViewModel


class DrinksAdapter(private  var drinkslist:List<DrinksItem>): RecyclerView.Adapter<DrinksAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksAdapter.ViewHolder {
        val binding: RowItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row_item, parent, false)
        return ViewHolder(binding)


    }

    override fun onBindViewHolder(holder: DrinksAdapter.ViewHolder, position: Int) {
        holder.bind(drinkslist[position])
        holder.itemView.tag = position





    }



    override fun getItemCount(): Int {
        return drinkslist.size
    }


    class ViewHolder(private val binding: RowItemBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = RowItemViewModel()


        fun bind(imgpojo: DrinksItem){
            viewModel.bind(imgpojo)
            binding.viewModel = viewModel
   }


    }

}