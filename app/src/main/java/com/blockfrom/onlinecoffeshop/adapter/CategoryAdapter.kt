package com.blockfrom.onlinecoffeshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blockfrom.onlinecoffeshop.R
import com.blockfrom.onlinecoffeshop.databinding.ViewholderCategoryBinding
import com.blockfrom.onlinecoffeshop.model.CategoryModel

class CategoryAdapter(val items: MutableList<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var selectedPosition = -1
    protected var lastSelectedPosition = -1

    inner class ViewHolder(val binding: ViewholderCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.titleCat.text = item.title

        holder.binding.root.setOnClickListener {

            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(selectedPosition)

        }

        if (selectedPosition==position){
            holder.binding.titleCat.setBackgroundResource(R.drawable.orange_bg)
        }
        else{
            holder.binding.titleCat.setBackgroundResource(R.drawable.edit_text_bg)
        }
    }
    override fun getItemCount(): Int =items.size




}