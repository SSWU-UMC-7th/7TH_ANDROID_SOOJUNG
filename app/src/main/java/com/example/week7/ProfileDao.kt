package com.example.week7

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

//Data Access Object
@Dao
interface ProfileDao {
    @Insert     // 사로운 프로필 추가
    fun insert(profile: Profile)

    @Update     // 기존 프로필 수정
    fun update(profile: Profile)

    @Delete     // 프로필 삭제
    fun delete(profile:Profile)

    @Query("SELECT * FROM Profile")     // 모든 프로필의 데이터 조회
    fun getAll(): List<Profile>
}