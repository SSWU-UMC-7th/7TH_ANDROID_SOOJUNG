package com.example.umc_practice.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.umc_practice.R

data class Item(val imageResId: Int, val text: String)

class EmotionViewModel : ViewModel() {
    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    init {
        _items.value = listOf(
            Item(R.drawable.img_yellow, "더없이 행복한 하루였어요"),
            Item(R.drawable.img_blue, "기쁘고 흥분돼요"),
            Item(R.drawable.img_purple, "더평범한 하루였어요"),
            Item(R.drawable.img_green, "생각이 많아지고 불안해요"),
            Item(R.drawable.img_red, "부글부글 화가나요")
        )
    }
}
