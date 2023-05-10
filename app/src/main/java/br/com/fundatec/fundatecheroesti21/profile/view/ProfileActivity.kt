package br.com.fundatec.fundatecheroesti21.profile.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.core.hide
import br.com.fundatec.core.show
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.databinding.ActivityProfileBinding
import br.com.fundatec.fundatecheroesti21.home.view.HomeActivity
import br.com.fundatec.fundatecheroesti21.profile.presentation.ProfileViewModel
import br.com.fundatec.fundatecheroesti21.profile.presentation.model.ProfileViewState
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    private val viewModel: ProfileViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeObserver()

        binding.btRegister.setOnClickListener {
            viewModel.validateInputs(
                password = binding.pwd.text.toString(),
                email = binding.email.text.toString(),
                name = binding.nome.text.toString(),
            )
        }
    }

    private fun initializeObserver() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                ProfileViewState.ShowHomeScreen -> showHome()
                ProfileViewState.ShowErrorMessage -> showSnackError()
                ProfileViewState.ShowEmailErrorMessage -> showEmailError()
                ProfileViewState.ShowPasswordErrorMessage -> showPasswordError()
                ProfileViewState.ShowLoading -> showLoading()
                ProfileViewState.ShowNameError -> showNameError()
            }
        }
    }

    private fun showLoading() {
        binding.pbLoading.show()
    }

    private fun showNameError() {
        binding.pbLoading.hide()
        binding.nome.error = getString(R.string.register_name_error_message)
    }

    private fun showEmailError() {
        binding.pbLoading.hide()
        binding.email.error = getString(R.string.register_email_error_message)
    }

    private fun showPasswordError() {
        binding.pbLoading.hide()
        binding.pwd.error = getString(R.string.register_pdw_error_message)
    }

    private fun showSnackError() {
        binding.pbLoading.hide()
        Snackbar.make(binding.root, R.string.login_error_message, Snackbar.LENGTH_LONG).show()
    }

    private fun showHome() {
        binding.pbLoading.hide()
        val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}