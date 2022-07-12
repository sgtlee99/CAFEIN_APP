package DB_Dao_Helper

import retrofit2.Call
import retrofit2.http.*

public interface Login_API {
    //login
    @POST("/android/login")
    fun getLoginResponse(@Body user : Login_User) : Call<String>
}
public interface Register_API {
    //register
    @POST("android/register")
    fun getRegisterResponse(@Body re_user : Register_User) : Call<String>
}