package com.example.flo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.flo.databinding.FragmentHomeBinding
import com.google.gson.Gson
import me.relex.circleindicator.CircleIndicator3
import java.util.ArrayList
import java.util.Timer
import java.util.TimerTask


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private var albumDatas = ArrayList<Album>()
    private lateinit var songDB: SongDatabase

    private val timer = Timer()  // Timer 설정
    private val handler = Handler(Looper.getMainLooper())  // Handler 설정

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

//        binding.homeAlbumImgIv1.setOnClickListener {
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frm , AlbumFragment())
//                .commitAllowingStateLoss()
//        }

        songDB = SongDatabase.getInstance(requireContext())!!
        albumDatas.addAll(songDB.albumDao().getAlbums()) // songDB에서 album list를 가져옵니다.
        Log.d("albumlist", albumDatas.toString())


        // 더미데이터랑 Adapter 연결
        val albumRVAdapter = AlbumRVAdapter(albumDatas)
        // 리사이클러뷰에 어댑터를 연결
        binding.homeTodayMusicAlbumRv.adapter = albumRVAdapter
        albumRVAdapter.setMyItemClickListener(object : AlbumRVAdapter.MyItemClickListener{

            override fun onItemClick(album: Album) {
                changeAlbumFragment(album)
            }

            override fun onRemoveAlbum(position: Int) {
                albumRVAdapter.removeItem(position)
            }
        })
        // 레이아웃 매니저 설정
        binding.homeTodayMusicAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val mainBannerAdapter = MainBannerVPAdapter(this)
        binding.homeMainBannerVp.adapter = mainBannerAdapter

        startAutoSlide(mainBannerAdapter)

        return binding.root
    }

    // 자동 슬라이드 함수 추가
    private fun startAutoSlide(adapter: MainBannerVPAdapter) {
        val runnable = object : Runnable {
            override fun run() {
                val nextItem = binding.homeMainBannerVp.currentItem + 1
                if (nextItem < adapter.itemCount) {
                    binding.homeMainBannerVp.currentItem = nextItem
                } else {
                    binding.homeMainBannerVp.currentItem = 0
                }
                handler.postDelayed(this, 3000) // 3초마다 반복
            }
        }
        handler.postDelayed(runnable, 3000) // 첫 실행은 3초 후
    }


    private fun changeAlbumFragment(album: Album) {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, AlbumFragment().apply {
                arguments = Bundle().apply {
                    val gson = Gson()
                    val albumJson = gson.toJson(album)
                    putString("album", albumJson)
                }
            })
            .commitAllowingStateLoss()
    }
}