package br.com.fundatec.fundatecheroesti21.login.data.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)
