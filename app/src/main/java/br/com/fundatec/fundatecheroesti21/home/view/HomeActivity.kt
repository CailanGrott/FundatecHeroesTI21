package br.com.fundatec.fundatecheroesti21.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.fundatecheroesti21.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = HomeViewPager(supportFragmentManager)
        binding.homeViewPager.adapter = adapter
        binding.homeTabLayout.setupWithViewPager(binding.homeViewPager)
    }
}

