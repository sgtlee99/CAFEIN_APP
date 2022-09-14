package DB_Dao_Helper


class Login_User {  //로그인
    var id : String? = null
    var pw : String? = null
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
//비밀번호, 닉네임, 이메일, 나이, 성별
class Update_User { //회원정보 수정
    var pw : String? = null
    var nick : String? = null
    var email : String? = null
    var age : Int?= 0
    var sex : String? = null
}