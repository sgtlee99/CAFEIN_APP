package DB_Dao_Helper

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Post_API {
    //login
    @POST("/android/postwrite")
    fun getLoginResponse(@Body user : Login_User) : Call<String>
}