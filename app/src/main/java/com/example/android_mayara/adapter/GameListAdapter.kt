package com.example.android_mayara.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.android_mayara.model.Game

class GameListAdapter(
    context: Context,
    private val games: MutableList<Game>
) : ArrayAdapter<Game>(context, android.R.layout.simple_list_item_1, games) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)

        val tv1 = view.findViewById<TextView>(android.R.id.text1)
        val tv2 = view.findViewById<TextView>(android.R.id.text2)

        val game = games[position]
        tv1.text = game.nome
        tv2.text = "Idade mínima: ${game.minAge}"

        return view
    }
}