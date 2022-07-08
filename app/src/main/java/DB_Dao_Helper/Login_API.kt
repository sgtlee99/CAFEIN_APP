package DB_Dao_Helper

import retrofit2.Call
import retrofit2.http.*

public interface Login_API {
    //login
    @POST("/android/login")
    fun getLoginResponse(@Body user : Login_User) : Call<String>

}