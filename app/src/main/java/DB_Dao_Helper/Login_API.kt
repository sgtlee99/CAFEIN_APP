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

public interface Update_API {
    //update
    @POST("android/update")
    fun getUpdateResponse(@Body up_user : Update_User) : Call<String>
}