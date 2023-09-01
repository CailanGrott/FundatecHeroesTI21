package br.com.fundatec.fundatecheroesti21.home.presentation.model

import br.com.fundatec.fundatecheroesti21.character.data.local.CharacterModel

sealed class HomeViewState {
    data class ShowHomeScreen(val list: List<CharacterModel>) : HomeViewState()

    object ShowEmptyList : HomeViewState()

    object ShowLoading : HomeViewState()
}