package DB_Dao_Helper

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//로그인에 들어갈 정보
//아이디, 비밀번호,
//    (tableName = "USER_TABLE")

@Entity
data class USER(
//    var title : String,
//    @ColumnInfo(name = "user_id")
    var user_id : String,

//    @ColumnInfo(name = "user_pw")
    var user_pw : String,

//    @ColumnInfo(name = "user_nick")
    var user_nick : String,

//    @ColumnInfo(name = "user_sex")
//    var userSEX : String
) {
    @PrimaryKey(autoGenerate = true)// PrimaryKey 를 자동적으로 생성
    var id: Int = 0
}
