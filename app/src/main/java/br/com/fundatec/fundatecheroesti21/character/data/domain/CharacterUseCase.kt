package br.com.fundatec.fundatecheroesti21.character.data.domain

import br.com.fundatec.fundatecheroesti21.character.data.local.CharacterModel
import br.com.fundatec.fundatecheroesti21.character.data.repository.CharacterRepository

class CharacterUseCase {

    private val repository by lazy { CharacterRepository() }

    suspend fun getCharacters(): List<CharacterModel>{
        return repository.getCharacters()
    }
}