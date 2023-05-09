package br.com.fundatec.fundatecheroesti21.presentation

import android.text.Editable
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val name = MutableLiveData<String>()
    val publicName: LiveData<String> = name

    private val helloVisibility = MutableLiveData<Int>()
    val visibility: LiveData<Int> = helloVisibility

    private val toast = MutableLiveData<Unit>()
    val showToast: LiveData<Unit> = toast

    fun validateName(text: Editable?) {
        val newText = text.toString()
        if (!newText.isNullOrBlank()) {
            name.value = newText
            helloVisibility.value = View.VISIBLE
        } else {
            toast.value = Unit
        }
    }

    fun clear() {
        name.value = ""
        helloVisibility.value = View.GONE
    }
}