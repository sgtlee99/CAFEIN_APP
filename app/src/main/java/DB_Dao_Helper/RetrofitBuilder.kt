package DB_Dao_Helper

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilder {
    var login_api : Login_API
    var register_api : Register_API
    var update_api : Update_API
    var post_api : Post_API

    var gson : Gson = GsonBuilder()
        .setLenient()
        .create()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://172.26.8.129:8080")//아이피 변경되면 같이 변경해줄것
            .addConverterFactory(GsonConverterFactory.create(gson))//Gson을 역직렬화
            .build()
        login_api = retrofit.create(Login_API::class.java)
        register_api = retrofit.create(Register_API::class.java)
        update_api = retrofit.create(Update_API::class.java)
        post_api = retrofit.create(Post_API::class.java)
    }
}