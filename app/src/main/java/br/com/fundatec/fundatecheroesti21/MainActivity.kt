package br.com.fundatec.fundatecheroesti21

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import br.com.fundatec.core.visible
import br.com.fundatec.fundatecheroesti21.presentation.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainViewModel()

        val container = findViewById<ConstraintLayout>(R.id.container)
        val etName = findViewById<EditText>(R.id.et_name)
        val btOk = findViewById<Button>(R.id.bt_ok)
        val btClear = findViewById<Button>(R.id.bt_clear)
        val tvHello = findViewById<TextView>(R.id.tv_hello)

        btOk.setOnClickListener {
            viewModel.validateName(etName.text)
        }

        btClear.setOnClickListener {
            viewModel.clear()
        }

        viewModel.publicName.observe(this) { name ->
            tvHello.text = getString(R.string.hello, name)
        }

        viewModel.visibility.observe(this) { visibility ->
            tvHello.visibility = visibility
            tvHello.visible()
        }

        viewModel.showToast.observe(this) {
            Snackbar.make(container, "Preencha os campos!!!", Snackbar.LENGTH_LONG).apply {
                anchorView = etName
            }.setAction("Desfazer") {
                showToast("Preencha os campos!!!")
            }.show()

        }
    }
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}
