package DB_Dao_Helper

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TagDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) //같은 데이터가 있으면 무시
    fun insertTag(taginfo : Tag_Info)

    @Delete
    fun deleteTag(taginfo : Tag_Info)

    @Update
    fun updateTag(taginfo : Tag_Info)

    @Query("SELECT * FROM Tag_Info ORDER BY Tag_Info.tag_num DESC")
    fun tag_getAll(): LiveData<List<Tag_Info>>

//    @Query("SELECT tag FROM Tag_Info ")
//    fun alltags() : LiveData<List<Tag_Info>>



    @Query("SELECT post_num FROM tag_info ORDER BY Tag_Info.tag_num DESC")
    fun getPostNum() : Int
    @Query("SELECT tag FROM tag_info ORDER BY Tag_Info.tag_num DESC")
    fun getTag() : String
    @Query("SELECT tag_num FROM tag_info ORDER BY Tag_Info.tag_num DESC")
    fun getTagNum() : Int

}