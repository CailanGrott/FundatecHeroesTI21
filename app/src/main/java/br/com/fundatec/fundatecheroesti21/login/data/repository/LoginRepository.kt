package br.com.fundatec.fundatecheroesti21.login.data.repository;

import android.util.Log
import br.com.fundatec.fundatecheroesti21.login.data.service.LoginService
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.math.log

class LoginRepository {
    private val client =
        RetrofitNetworkClient
            .createNetworkClient()
            .create(LoginService::class.java)

    suspend fun login(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = client.getUser(email, password)
                response.isSuccessful && response.body() != null
            } catch (exception: Exception) {
                Log.e("login", exception.message.orEmpty())
                false
            }
        }
    }
}