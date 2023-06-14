package br.com.fundatec.fundatecheroesti21.login.data.repository

import br.com.fundatec.fundatecheroesti21.login.data.remote.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginService {

    @GET("/api/login")
    suspend fun getUser(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<LoginResponse>
}