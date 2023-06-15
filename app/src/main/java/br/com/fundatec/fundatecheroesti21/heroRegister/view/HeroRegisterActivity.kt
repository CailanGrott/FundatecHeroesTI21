package br.com.fundatec.fundatecheroesti21.heroRegister.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.core.hide
import br.com.fundatec.core.show
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.databinding.ActivityHeroRegisterBinding
import br.com.fundatec.fundatecheroesti21.heroRegister.presentation.HeroesRegisterViewModel
import br.com.fundatec.fundatecheroesti21.heroRegister.presentation.model.HeroRegisterViewState
import br.com.fundatec.fundatecheroesti21.home.view.HomeActivity
import com.google.android.material.snackbar.Snackbar

class HeroRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroRegisterBinding

    private val viewModel: HeroesRegisterViewModel by viewModels();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeObserver()

        binding.floatingButton.setOnClickListener {
            viewModel.validateInputs(
                name = binding.nameHero.text.toString(),
                description = binding.description.text.toString(),
                age = binding.age.text.toString(),
                birth_date = binding.birthDate.text.toString()
            )
        }
    }

    private fun initializeObserver() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                HeroRegisterViewState.ShowHomeScreen -> showHome()
                HeroRegisterViewState.ShowLoading -> showLoading()
                HeroRegisterViewState.ShowNameError -> showNameError()
                HeroRegisterViewState.ShowMessageError -> showSnackError()
                HeroRegisterViewState.ShowDescriptionError -> showDescriptionError()
                HeroRegisterViewState.ShowAgeError -> showAgeError()
                HeroRegisterViewState.ShowBirthDateError -> showBirthDateError()
            }
        }
    }

    private fun showLoading() {
        binding.pbLoading.show()
    }

    private fun showAgeError() {
        binding.pbLoading.hide()
        binding.age.error = getString(R.string.register_age_error_message)
    }
    private fun showBirthDateError() {
        binding.pbLoading.hide()
        binding.birthDate.error = getString(R.string.register_birthDate_error_message)
    }

    private fun showNameError() {
        binding.pbLoading.hide()
        binding.nameHero.error = getString(R.string.register_name_error_message)
    }

    private fun showHome() {
        binding.pbLoading.hide()
        val intent = Intent(this@HeroRegisterActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showSnackError() {
        binding.pbLoading.hide()
        Snackbar.make(binding.root, R.string.login_error_message_hero_register, Snackbar.LENGTH_LONG).show()
    }

    private fun showDescriptionError() {
        binding.pbLoading.hide()
        binding.description.error = getString(R.string.register_description_error_message)
    }
}