package br.com.fundatec.fundatecheroesti21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.fundatec.fundatecheroesti21.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheroesti21.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btOk.setOnClickListener{
            val intent = Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()

        }


    }
}