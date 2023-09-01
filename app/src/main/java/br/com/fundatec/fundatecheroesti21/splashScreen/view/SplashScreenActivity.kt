package br.com.fundatec.fundatecheroesti21.splashScreen.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.home.view.HomeActivity
import br.com.fundatec.fundatecheroesti21.login.view.LoginActivity
import br.com.fundatec.fundatecheroesti21.splashScreen.presentation.model.SplashScreenViewState
import br.com.fundatec.fundatecheroesti21.splashScreen.presentation.SplashScreenViewModel

class SplashScreenActivity : AppCompatActivity() {


    private val viewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                SplashScreenViewState.ShowHome -> showHome()
                SplashScreenViewState.ShowLogin -> showLogin()
            }
        }
    }

    private fun showHome() {
        startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
        finish()
    }

    private fun showLogin() {
        startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
        finish()
    }
}
