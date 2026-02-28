package com.example.android_mayara

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_mayara.databinding.ActivityLoginOkactivityBinding
import com.example.android_mayara.databinding.ActivityMainBinding

class LoginOkActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityLoginOkactivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val nome = intent.getStringExtra("nomeUser") ?: "Utilizador"
        val anoNascimento = intent.getIntExtra("anoNascimento", 0)

        val textViewBemVindo = findViewById<TextView>(R.id.textViewBemVindo)
        textViewBemVindo.text = "Bem-vindo, $nome!"
    }
}
