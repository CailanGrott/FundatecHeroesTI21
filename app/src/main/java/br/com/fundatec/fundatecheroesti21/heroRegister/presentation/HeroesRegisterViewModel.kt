package br.com.fundatec.fundatecheroesti21.heroRegister.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroesti21.heroRegister.presentation.model.HeroRegisterViewState
import java.util.regex.Pattern

class HeroesRegisterViewModel : ViewModel() {
    private val viewState = MutableLiveData<HeroRegisterViewState>()
    val state: LiveData<HeroRegisterViewState> = viewState
    fun validateInputs(name: String?, description: String?, age: String?, birth_date: String?) {
        var patternAge = Pattern.compile("[0-9]")
        var matcherAge = patternAge.matcher(age)

        var patternBirthDate = Pattern.compile("\\d{2}[-\\/\\.]\\d{2}[-\\/\\.]\\d{4}|\\d{8}")
        var matcherBirthDate = patternBirthDate.matcher(birth_date)

        viewState.value = HeroRegisterViewState.ShowLoading

        if (name.isNullOrBlank() && description.isNullOrBlank() && age.toString()
                .isNullOrBlank() && birth_date.toString().isNullOrBlank()
        ) {
            viewState.value = HeroRegisterViewState.ShowMessageError
            return
        }

        if (name.isNullOrBlank()) {
            viewState.value = HeroRegisterViewState.ShowNameError
            return
        }
        if (description.isNullOrBlank()) {
            viewState.value = HeroRegisterViewState.ShowDescriptionError
            return
        }
        if (!matcherAge.matches()) {
            viewState.value = HeroRegisterViewState.ShowAgeError
            return
        }

        if (age.isNullOrBlank() || age.equals("0")) {
            viewState.value = HeroRegisterViewState.ShowAgeError
            return
        }

        if (!matcherBirthDate.matches()) {
            viewState.value = HeroRegisterViewState.ShowBirthDateError
            return
        }

        if (birth_date.isNullOrBlank()) {
            viewState.value = HeroRegisterViewState.ShowNameError
            return
        }

        fetchLogin(name, description, age, birth_date)
    }

    private fun fetchLogin(name: String, description: String, age: String, birth_date: String) {
        viewState.value = HeroRegisterViewState.ShowHomeScreen
    }
}