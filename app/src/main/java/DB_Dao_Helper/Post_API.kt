package DB_Dao_Helper

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

public interface Post_API {
    //login
    @POST("/android/postwrite")
    fun getPostResponse(@Body user : Login_User) : Call<String>//포스트바꿔야됨
}

//public interface PostReview_API {
//    @POST("android/postreview")
//    fun getPostrivewResponse(@Body ) : Call<String>
//}