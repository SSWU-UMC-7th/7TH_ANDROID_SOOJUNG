package com.example.pinterest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pinterest.R
import com.example.pinterest.adapters.ImageAdapter
import com.example.pinterest.databinding.FragmentHomeBinding
import com.example.pinterest.models.ImageItem

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 임의의 이미지 데이터 리스트 생성 (drawable 리소스를 사용하여 10개의 이미지)
        val imageItems = listOf(
            ImageItem(R.drawable.image1),
            ImageItem(R.drawable.image2),
            ImageItem(R.drawable.image3),
            ImageItem(R.drawable.image4),
            ImageItem(R.drawable.image5),
            ImageItem(R.drawable.image6),
            ImageItem(R.drawable.image7),
            ImageItem(R.drawable.image8),
            ImageItem(R.drawable.image9),
            ImageItem(R.drawable.image10)
        )

        // RecyclerView 설정
        setupRecyclerView(imageItems)
    }

    private fun setupRecyclerView(items: List<ImageItem>) {
        // ImageAdapter 생성
        val imageAdapter = ImageAdapter(items)

        // StaggeredGridLayoutManager를 사용하여 Pinterest 스타일의 불규칙한 그리드 레이아웃 설정
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = imageAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}