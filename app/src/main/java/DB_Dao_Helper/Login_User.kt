package DB_Dao_Helper


class Login_User {  //로그인
    var id : String? = null
    var password : String? = null
}

class Register_User {   //회원가입
    var id : String? = null
    var pw : String? = null
    var nick : String? = null
    var com : String? = null
    var email : String? = null
    var groups : String? = null
    var sex : String? = null
    var age : Int? = 0
}

class Update_User {
    var pw : String? = null
    var nick : String? = null
    var email : String? = null
    var proImage : String? = null
    var age : Int?= 0
    var sex : String? = null
}