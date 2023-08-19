package br.com.fundatec.fundatecheroesti21.characterRegister.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroesti21.character.data.CharacterRequest
import br.com.fundatec.fundatecheroesti21.character.data.repository.CharacterRepository
import br.com.fundatec.fundatecheroesti21.character.presentation.model.CharacterViewState
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class CharacterRegisterViewModel : ViewModel() {

    private val viewState = MutableLiveData<CharacterViewState>()
    private val repository by lazy { CharacterRepository() }
    val state: LiveData<CharacterViewState> = viewState
    fun validateInputs(
        name: String?, description: String?, image: String?, universeType: String?,
        characterType: String?, age: String?, birthday: String?
    ) {

        var patternBirthDay = Pattern.compile("\\d{2}[-\\/\\.]\\d{2}[-\\/\\.]\\d{4}|\\d{8}")
        var matcherBirthDay = patternBirthDay.matcher(birthday)

        viewState.value = CharacterViewState.ShowLoading

        if (name.isNullOrBlank() && description.isNullOrBlank() && age.toString()
                .isNullOrBlank() && birthday.toString().isNullOrBlank()
        ) {
            viewState.value = CharacterViewState.ShowMessageError
            return
        }

        if (name.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowNameError
            return
        }
        if (description.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowDescriptionError
            return
        }

        if (age.isNullOrBlank() || age.equals("0")) {
            viewState.value = CharacterViewState.ShowAgeError
            return
        }

        if (!matcherBirthDay.matches()) {
            viewState.value = CharacterViewState.ShowBirthdayError
            return
        }

        if (birthday.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowNameError
            return
        }

        createCharacter(name, description, image, universeType, characterType, age, birthday)
    }

    fun createCharacter(
        name: String?, description: String?, image: String?, universeType: String?,
        characterType: String?, age: String?, birthday: String?
    ) {
        viewModelScope.launch {
            try {
                val character = CharacterRequest(
                    name = name ?: "",
                    description = description ?: "",
                    image = image ?: "",
                    universeType = universeType ?: "",
                    characterType = characterType ?: "",
                    age = age?.toIntOrNull() ?: 0,
                    birthday = birthday ?: ""
                )
                val response = repository.createCharacter(character)

                if (response) {
                    viewState.value = CharacterViewState.ShowHomeScreen
                } else {
                    viewState.value = CharacterViewState.ShowMessageError
                }
            } catch (e: Exception) {
                viewState.value = CharacterViewState.ShowMessageError
            }
        }
    }
}