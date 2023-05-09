package br.com.fundatec.fundatecheroesti21.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroesti21.profile.presentation.model.ProfileViewState

class ProfileViewModel : ViewModel() {
    private val viewState = MutableLiveData<ProfileViewState>()
    val state: LiveData<ProfileViewState> = viewState

    fun validateInputs(email: String?, password: String?) {
        viewState.value = ProfileViewState.ShowLoading
        if (email.isNullOrBlank() && password.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowErrorMessage
            return
        }

        if (email.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowEmailErrorMessage
            return
        }

        if (password.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowPasswordErrorMessage
            return
        }

        fetchLogin(email, password)
    }

    private fun fetchLogin(email: String, password: String) {
        viewState.value = ProfileViewState.ShowHomeScreen
    }
}