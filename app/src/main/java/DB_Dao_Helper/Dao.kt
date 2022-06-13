package com.example.dbtest

import DB_Dao_Helper.USER
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DAO {
    //추가
//    fun insert(user: USER)

    @Insert
    fun insert(user: USER)

    //삭제
    @Delete
    fun delete(user: USER)

    //업데이트
    @Update
    fun update(user : USER)

    //데이터 베이스 불러오기
    @Query("SELECT * FROM USER ORDER BY id DESC")
    fun getAll(): LiveData<List<USER>>

    @Query("SELECT * FROM USER WHERE USER.user_id LIKE :userID")
    fun isUserIDExist(userID: String): USER?        //사용자의 이름이 없으면 NULL을 반환


    @Query("SELECT USER.user_pw FROM USER WHERE USER.user_id LIKE :userID")
    fun pwcorrect(userID : String) : String         //아이디를 넣으면 비밀번호를 반환

    @Query("SELECT USER.user_id FROM USER WHERE USER.user_pw LIKE :userPW")
    fun idcorrect(userPW : String) : String         //비밀번호를 넣으면 아이디를 반환

    @Query("SELECT USER.user_nick FROM USER WHERE USER.user_id LIKE :userID")
    fun showNickname(userID : String) : String      //아이디를 넣으면 닉네임을 반환

}