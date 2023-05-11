package br.com.fundatec.fundatecheroesti21.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.core.hide
import br.com.fundatec.fundatecheroesti21.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheroesti21.heroRegister.view.HeroRegisterActivity
import br.com.fundatec.fundatecheroesti21.profile.view.ProfileActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = HomeViewPager(supportFragmentManager)
        binding.homeViewPager.adapter = adapter
        binding.homeTabLayout.setupWithViewPager(binding.homeViewPager)

        binding.btLogin.setOnClickListener {
            showHeroesRegister()
        }
    }

    private fun showHeroesRegister() {
        val intent = Intent(this@HomeActivity, HeroRegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}

