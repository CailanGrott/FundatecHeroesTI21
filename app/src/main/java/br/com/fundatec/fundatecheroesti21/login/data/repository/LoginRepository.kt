package br.com.fundatec.fundatecheroesti21.login.data.repository

import android.util.Log
import br.com.fundatec.fundatecheroesti21.character.data.repository.CharacterService
import br.com.fundatec.fundatecheroesti21.database.FHDatabase
import br.com.fundatec.fundatecheroesti21.login.data.LoginResponse
import br.com.fundatec.fundatecheroesti21.login.data.UserRequest
import br.com.fundatec.fundatecheroesti21.login.data.local.UserEntity
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.util.*

class LoginRepository {
    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }

    private val client =
        RetrofitNetworkClient
            .createNetworkClient()
            .create(LoginService::class.java)



    suspend fun login(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = client.getUser(email, password)
                saveUserLogin(response)
                response.isSuccessful
            } catch (exception: Exception) {
                Log.e("login", exception.message.orEmpty())
                false
            }
        }
    }

    private suspend fun saveUserLogin(user: Response<LoginResponse>) {
        return withContext(Dispatchers.IO) {
            if (user.isSuccessful) {
                user.body()?.run {
                    database.userDao().insertUser(
                        userResponseToEntity()
                    )
                }
            }
        }
    }

    private fun LoginResponse.userResponseToEntity(): UserEntity {
        return UserEntity(
            id = id,
            name = name,
            email = email,
            password = password,
        )
    }


    suspend fun createUser(name: String, email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = client.postUser(UserRequest(name, email, password))
                response.isSuccessful
            } catch (exception: Exception) {
                Log.e("createUser", exception.message.orEmpty())
                false
            }
        }

    }

    suspend fun getCacheDate(): Date? {
        return withContext(Dispatchers.IO) {
            database.userDao().getUserDate()
        }
    }

    suspend fun clearCache() {
        return withContext(Dispatchers.IO) {
            database.userDao().clearCache()
        }
    }
}

