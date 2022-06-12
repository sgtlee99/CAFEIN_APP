package DB_Dao_Helper

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dbtest.DAO

@Database(entities = [USER::class],   version = 1, exportSchema = false)
abstract class LoginDatabase : RoomDatabase() {

    abstract fun dao(): DAO
// 싱글톤 방식 - 권장
//    companion object {
//        private var instance: LoginDatabase? = null
//
//        @Synchronized
//        fun getInstance(context: Context): LoginDatabase? {
//            if (instance == null) {
//                synchronized(LoginDatabase::class) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        LoginDatabase::class.java,
//                        "login-database"
//                    ).build()
//                }
//            }
//            return instance
//        }
//    }
}
