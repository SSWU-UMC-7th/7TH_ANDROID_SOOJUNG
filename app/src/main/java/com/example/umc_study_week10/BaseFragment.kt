package com.example.umc_study_week10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.umc_study_week10.utils.autoCleaned

// 추상화 클래스
// 클래스의 틀을 복제
abstract class BaseFragment<VB : ViewBinding> :
    Fragment() {
    private var _binding: VB by autoCleaned()
    val binding: VB get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater, container)
        return binding.root
    }

    abstract fun initView()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

}