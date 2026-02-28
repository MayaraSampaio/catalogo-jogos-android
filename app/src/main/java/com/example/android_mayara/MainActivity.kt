package com.example.android_mayara

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_mayara.databinding.ActivityMainBinding
import com.example.android_mayara.model.User
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val usersPredefinidos = listOf(
            User("admin", "1234", "Admin", 1990),
            User("mayara", "pass", "Mayara", 2002),
            User("jose", "abcd", "Jose", 1998),
            User("Sara", "1111", "Sara", 2005),
            User("rui", "2222", "Rui", 1987),
            User("Thais", "3333", "Thais", 2001),
            User("pedro", "4444", "Pedro", 2010),
            User("Victor", "5555", "Victor", 1995)
        )

        binding.buttonLogin.setOnClickListener{

            var usernameInserido = binding.editTextUsername.text.toString()
            var passwordInserida = binding.editTextPassword.text.toString()



            var userEncontrado = usersPredefinidos.firstOrNull { user ->
                user.username == usernameInserido && user.password == passwordInserida
            }

            if (userEncontrado != null) {// Login válido
                var intent = Intent(this, WishlistActivity::class.java)

                // manda dados do USER, nome e ano de nascimento
                intent.putExtra("nomeUser", userEncontrado.nome)
                intent.putExtra("anoNascimento", userEncontrado.anoNascimento)
                intent.putExtra("username", userEncontrado.username)

                startActivity(intent)

            }else{ // Login inválido e limpa os campos de username e password
                Toast.makeText(this, "Senha incorreta", Toast.LENGTH_SHORT).show()
                binding.editTextUsername.text?.clear()
                binding.editTextPassword.text?.clear()
            }

        }

    }

}