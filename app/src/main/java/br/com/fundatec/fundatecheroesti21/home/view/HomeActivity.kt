package br.com.fundatec.fundatecheroesti21.home.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheroesti21.character.data.local.CharacterModel
import br.com.fundatec.fundatecheroesti21.characterRegister.view.CharacterListAdapter
import br.com.fundatec.fundatecheroesti21.characterRegister.view.CharacterRegisterActivity
import br.com.fundatec.fundatecheroesti21.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheroesti21.home.presentation.HomeViewModel
import br.com.fundatec.fundatecheroesti21.home.presentation.model.HomeViewState

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val characterListAdapter by lazy {
        CharacterListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = characterListAdapter

        initializeObserver()
        navigateNewCharacter()
    }

    override fun onResume() {
        super.onResume()
        viewModel.listCharacter()
    }

    private fun initializeObserver() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                is HomeViewState.ShowHomeScreen -> showHomeScreen(viewState.list)
                HomeViewState.ShowEmptyList -> showEmptyList()
                HomeViewState.ShowLoading -> showLoading()
            }
        }
    }

    private fun showHomeScreen(list: List<CharacterModel>) {
        characterListAdapter.add(list)
    }

    fun showEmptyList() {

    }

    fun showLoading() {

    }


    private fun navigateNewCharacter() {
        binding.btNewCharacter.setOnClickListener {

            val intent = Intent(this@HomeActivity, CharacterRegisterActivity::class.java)
            startActivity(intent)
        }
    }

}

