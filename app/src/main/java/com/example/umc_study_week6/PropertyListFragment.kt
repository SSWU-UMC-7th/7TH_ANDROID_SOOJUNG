package com.example.umc_study_week6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PropertyListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_property_list, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        // 여러 개의 숙소 데이터를 생성
        val propertyList = listOf(
            Property(R.drawable.ic_property_placeholder, "강원도 양양군 별장",  "4.88", "62km 거리", "11월 11일~16일", "₩479,143 /박"),
            Property(R.drawable.ic_property_placeholder2, "한국 인천",  "4.92", "34km 거리", "12월 5일~10일", "₩467,883 /박"),
            Property(R.drawable.ic_property_placeholder3, "한국 가평군",  "4.85", "47km 거리", "12월 15일~20일", "₩114,118/박"),
            Property(R.drawable.ic_property_placeholder4, "한국 종로구",  "4.94", "2km 거리", "1월 1일~6일", "₩232,800 /박"),
            Property(R.drawable.ic_property_placeholder5, "한국 애월읍, 제주시",  "4.80", "800km 거리", "11월 30일~12월 5일", "₩183,033 /박")
            // 더 많은 숙소 데이터 추가 가능
        )

        // Adapter 설정
        val adapter = PropertyAdapter(propertyList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}


