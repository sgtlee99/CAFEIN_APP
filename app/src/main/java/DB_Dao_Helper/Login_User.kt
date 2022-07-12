package DB_Dao_Helper

class Login_User {
    var id : String? = null
        get(){return field}
        set(value){field = value}

    var password : String? = null
        get(){return field}
        set(value){field = value}
}
//아이디, 비번, 닉네임, owner, 이메일, 그룹, 성별, 나이
class Register_User {
    var id : String? = null
        get(){return field}
        set(value){field = value}
    var pw : String? = null
        get(){return field}
        set(value){field = value}
    var nick : String? = null
        get(){return field}
        set(value){field = value}
    var com : String? = null
        get(){return field}
        set(value){field = value}
    var email : String? = null
        get(){return field}
        set(value){field = value}
    var group : String? = null
        get(){return field}
        set(value){field = value}
    var sex : String? = null
        get(){return field}
        set(value){field = value}
    var age : Int? = 0
        get(){return field}
        set(value){field = value}
}