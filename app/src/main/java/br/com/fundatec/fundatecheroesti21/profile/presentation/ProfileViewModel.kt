package br.com.fundatec.fundatecheroesti21.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroesti21.profile.presentation.model.ProfileViewState
import java.util.regex.Pattern

class ProfileViewModel : ViewModel() {
    private val viewState = MutableLiveData<ProfileViewState>()
    val state: LiveData<ProfileViewState> = viewState

    fun validateInputs(name: String?, email: String?, password: String?) {
        var patternEmail = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")
        var matcherEmail = patternEmail.matcher(email)

        viewState.value = ProfileViewState.ShowLoading
        if (email.isNullOrBlank() && password.isNullOrBlank() && name.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowErrorMessage
            return
        }

        if (name.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowNameError
            return
        }

        if (!matcherEmail.matches()) {
            viewState.value = ProfileViewState.ShowEmailErrorMessage
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

        fetchLogin(name, email, password)
    }

    private fun fetchLogin(name: String, email: String, password: String) {
        viewState.value = ProfileViewState.ShowHomeScreen
    }
}