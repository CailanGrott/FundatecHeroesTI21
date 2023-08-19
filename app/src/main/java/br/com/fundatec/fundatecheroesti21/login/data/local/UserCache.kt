package br.com.fundatec.fundatecheroesti21.login.data.local

class UserCache {

    private val users: MutableMap<String, UserEntity> = HashMap()
    private var lastLoginTime: Long = 0

    fun saveUser(email:String,user:UserEntity){
        users[email] = user
        lastLoginTime = System.currentTimeMillis()
    }

    fun getUser(email:String):UserEntity?{
        return users[email]
    }

    fun cleanCache(){
        users.clear()
        lastLoginTime = 0
    }

    fun isCacheValid() : Boolean{
        val currentTime = System.currentTimeMillis()
        return (currentTime - lastLoginTime) <= 60000
    }
}