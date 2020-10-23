package com.dev.kotlinproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dev.kotlinproject.databinding.RecyclerItemBinding

/**
 * Created by Rasul Mamadov on 10/23/2020.
 */
class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<RecyclerData>()

    fun setDataList(data: ArrayList<RecyclerData>) {
        this.items = data
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerItemBinding.inflate(layoutInflater)

        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount() = items.size

    class MyViewHolder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: RecyclerData) {
            binding.recyclerData = data
            binding.executePendingBindings()
        }

    }

    companion object {
        @BindingAdapter("loadImage")
        fun loadImage(cardMainImage: ImageView, url: String) {
            Glide.with(cardMainImage)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(cardMainImage)
        }
    }
}