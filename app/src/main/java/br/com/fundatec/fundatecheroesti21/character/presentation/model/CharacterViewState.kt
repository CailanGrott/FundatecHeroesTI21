package br.com.fundatec.fundatecheroesti21.character.presentation.model

sealed class CharacterViewState {
    object ShowHomeScreen : CharacterViewState()
    object ShowLoading : CharacterViewState()
    object ShowNameError : CharacterViewState()
    object ShowDescriptionError : CharacterViewState()
    object ShowMessageError : CharacterViewState()
    object ShowAgeError : CharacterViewState()
    object ShowBirthdayError : CharacterViewState()
    object ShowImageError : CharacterViewState()
}