package DB_Dao_Helper

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TagDao {
    @Insert
    fun insertTag(taginfo : Tag_Info)

    @Delete
    fun deleteTag(taginfo : Tag_Info)

    @Update
    fun updateTag(taginfo : Tag_Info)

    @Query("SELECT * FROM Tag_Info ORDER BY Tag_Info.tag_num DESC")
    fun tag_getAll(): LiveData<List<Tag_Info>>

}