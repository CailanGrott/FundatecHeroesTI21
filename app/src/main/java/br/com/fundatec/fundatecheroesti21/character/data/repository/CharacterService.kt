package br.com.fundatec.fundatecheroesti21.character.data.repository

import br.com.fundatec.fundatecheroesti21.character.data.CharacterRequest
import br.com.fundatec.fundatecheroesti21.character.data.CharacterResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.*

interface CharacterService {

    @POST("/api/character/{idUser}")
    suspend fun createCharacter(
        @Path("idUser") idUser:Int,
        @Body characterRequest: CharacterRequest
    ):Response<ResponseBody>

    @GET("/api/character/{idUser}")
    suspend fun getCharacter(@Path("idUser") idUser: Int): Response<List<CharacterResponse>>

}