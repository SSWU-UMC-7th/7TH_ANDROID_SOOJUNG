package com.example.pinterest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pinterest.databinding.ItemImageBinding
import com.example.pinterest.models.ImageItem

// ImageAdapter는 RecyclerView에 ImageItem 리스트를 표시하는 어댑터입니다.
class ImageAdapter(private val items: List<ImageItem>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    // ViewHolder는 개별 이미지 항목을 관리하는 클래스입니다.
    inner class ImageViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        // bind 메서드는 이미지 데이터를 뷰에 바인딩합니다.
        fun bind(item: ImageItem) {
            binding.imageView.setImageResource(item.imageResId)
        }
    }

    // onCreateViewHolder는 ViewHolder를 생성할 때 호출됩니다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    // onBindViewHolder는 데이터를 ViewHolder에 바인딩합니다.
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    // getItemCount는 데이터 리스트의 크기를 반환합니다.
    override fun getItemCount(): Int = items.size
}