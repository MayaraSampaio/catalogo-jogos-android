package com.example.android_mayara

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_mayara.adapter.GameListAdapter
import com.example.android_mayara.model.Game
import java.util.Calendar

class WishlistActivity : AppCompatActivity() {

    private val catalogoCompleto = listOf(
        Game(1, "Tetris", 3),
        Game(2, "Super Mario Odyssey", 7),
        Game(3, "Sonic Mania", 7),
        Game(4, "Minecraft", 7),
        Game(5, "Among Us", 7),
        Game(6, "Zelda: Breath of the Wild", 12),
        Game(7, "Street Fighter 6", 12),
        Game(8, "Fortnite", 12),
        Game(9, "Elden Ring", 16),
        Game(10, "The Last of Us", 16),
        Game(11, "God of War", 18),
        Game(12, "GTA V", 18),
        Game(13, "Red Dead Redemption 2", 18),
        Game(14, "Call of Duty: Warzone", 18),
        Game(15, "Cyberpunk 2077", 18)
    )

    private val catalogoFiltrado = mutableListOf<Game>()
    private val desejos = mutableListOf<Game>()

    private lateinit var adapterCatalogo: GameListAdapter
    private lateinit var adapterDesejos: GameListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        val nome = intent.getStringExtra("nomeUser") ?: "Utilizador"
        val anoNascimento = intent.getIntExtra("anoNascimento", 2000)
        val idade = calculaIdade(anoNascimento)

        // Filtrar catálogo por idade
        catalogoFiltrado.addAll(catalogoCompleto.filter { it.minAge <= idade })

        findViewById<TextView>(R.id.tvTopo).text = "Bem-vindo, $nome! (idade: $idade)"

        val listCatalogo = findViewById<ListView>(R.id.listCatalogo)
        val listDesejos = findViewById<ListView>(R.id.listDesejos)

        adapterCatalogo = GameListAdapter(this, catalogoFiltrado)
        adapterDesejos = GameListAdapter(this, desejos)

        listCatalogo.adapter = adapterCatalogo
        listDesejos.adapter = adapterDesejos

        // Clique no catálogo: adiciona sem repetir
        listCatalogo.setOnItemClickListener { _, _, position, _ ->
            val game = catalogoFiltrado[position]

            val jaExiste = desejos.any { it.id == game.id }
            if (jaExiste) {
                Toast.makeText(this, "Já está na lista de desejos", Toast.LENGTH_SHORT).show()
            } else {
                desejos.add(game)
                adapterDesejos.notifyDataSetChanged()
                Toast.makeText(this, "Adicionado: ${game.nome}", Toast.LENGTH_SHORT).show()
            }
        }

        // Clique nos desejos: remove
        listDesejos.setOnItemClickListener { _, _, position, _ ->
            val removido = desejos.removeAt(position)
            adapterDesejos.notifyDataSetChanged()
            Toast.makeText(this, "Removido: ${removido.nome}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculaIdade(anoNascimento: Int): Int {
        val anoAtual = Calendar.getInstance().get(Calendar.YEAR)
        return anoAtual - anoNascimento
    }

}