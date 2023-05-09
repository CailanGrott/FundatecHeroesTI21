package br.com.fundatec.fundatecheroesti21

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import br.com.fundatec.core.show
import br.com.fundatec.fundatecheroesti21.databinding.ActivityMainBinding
import br.com.fundatec.fundatecheroesti21.presentation.MainViewModel
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        val image = findViewById<ImageView>(R.id.image)
        Glide
            .with(image.context)
            .load("https://e1.pngegg.com/pngimages/889/193/png-clipart-goku-son-goku-thumbnail.png")
            .into(image)

        binding.btOk.setOnClickListener {
            viewModel.validateName(binding.etName.text)
        }
        // Realizar o click através do xml utilizando viewbinging
        binding.btClear.setOnClickListener {
            viewModel.clear()
        }
        // Mudar a visibilidade utilizando viewbinding, ou seja utilizando as variaveis direto no xml
        viewModel.visibility.observe(this@MainActivity) { visibility ->
            binding.tvHello.visibility = visibility
            binding.tvHello.show()
        }

        viewModel.showToast.observe(this@MainActivity) {
            Snackbar.make(binding.container, "Preencha os campos!!!", Snackbar.LENGTH_LONG).apply {
                anchorView = binding.etName
            }.setAction("Desfazer") {
                showToast("Preencha os campos!!!")
            }.show()

        }
    }
}

@BindingAdapter(value = ["app:customVisibility"], requireAll = false)
fun View.setVisibility(visibility: Boolean) {
    this.isVisible = visibility
}

@BindingAdapter(value = ["app:customText"], requireAll = false)
fun TextView.setText(text: String?) {
    this.text = context.getString(R.string.hello, text)
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}
