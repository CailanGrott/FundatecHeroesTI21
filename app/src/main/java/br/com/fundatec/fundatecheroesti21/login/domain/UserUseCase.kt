package br.com.fundatec.fundatecheroesti21.login.domain

import br.com.fundatec.fundatecheroesti21.login.data.repository.LoginRepository

class UserUseCase {
    private val repository by lazy { LoginRepository() }

    suspend fun createUser(name:String,email: String, password: String): Boolean {
        return repository.createUser(name=name,email = email, password = password)
    }
}