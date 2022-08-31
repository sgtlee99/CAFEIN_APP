package DB_Dao_Helper

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
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
            .baseUrl("http://172.26.13.188:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))//Gson을 역직렬화
//            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        login_api = retrofit.create(Login_API::class.java)
        register_api = retrofit.create(Register_API::class.java)
        update_api = retrofit.create(Update_API::class.java)
        post_api = retrofit.create(Post_API::class.java)
    }
}