package DB_Dao_Helper

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tag_Info (
    val post_num : Int,
    val tag : String
    ) {

    @PrimaryKey(autoGenerate = true)// PrimaryKey 를 자동적으로 생성
    var tag_num: Int = 0
}