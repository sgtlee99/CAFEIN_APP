package DB_Dao_Helper

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilder {
    var api : Login_API
    var gson : Gson = GsonBuilder()
        .setLenient()
        .create()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.6:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))//Gson을 역직렬화
            .build()
        api = retrofit.create(Login_API::class.java)
    }
}