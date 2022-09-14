package DB_Dao_Helper

import android.provider.ContactsContract.DisplayPhoto
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

public interface Post_API {
    //login
//    @Multipart
    @POST("/android/cafePost")
    fun getPostResponse(@Body post_up : Post_Write) : Call<String>//포스트바꿔야됨 //텍스트만?

    @Multipart
    @POST("/android/postimagewrite")
    fun getPostimageResponse(@Part photo: MultipartBody.Part ) : Call<ImageTransport> //이미지


}

data class ImageTransport(var result : String? = null) {}
//public interface PostReview_API {
//    @POST("android/postreview")
//    fun getPostrivewResponse(@Body ) : Call<String>
//}