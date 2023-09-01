package br.com.fundatec.fundatecheroesti21.splashScreen.presentation.model

sealed class SplashScreenViewState {
    object ShowHome : SplashScreenViewState()
    object ShowLogin : SplashScreenViewState()
}