package com.example.android_mayara

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_mayara.databinding.ActivityMainBinding
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener{

            var usernameInserido = binding.editTextUsername.text.toString()
            var passwordInserida = binding.editTextPassword.text.toString()

            if(passwordInserida == "pass"){ // Login válido

                // Redirecionar para LoginOk
                val intent = Intent(this,LoginOkActivity::class.java)

                intent.putExtra("nomeUser",usernameInserido)

                startActivity(intent)

            }else{ // Login inválido
                // inserir um toast aqui


            }

        }

    }

}