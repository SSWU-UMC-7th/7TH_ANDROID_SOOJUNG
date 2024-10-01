package com.example.umc_practice.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_practice.databinding.EmotionLayoutBinding
import com.example.umc_practice.ui.viewmodel.Item
import com.example.umc_practice.ui.activity.DetailActivity

class EmotionAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<EmotionAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: EmotionLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.imageView.setImageResource(item.imageResId)
            binding.textView.text = item.text


            binding.root.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("EXTRA_TEXT", item.text)
                    putExtra("EXTRA_IMAGE", item.imageResId)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = EmotionLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
