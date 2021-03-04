package com.senai.sp.jandira.roomtest2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.senai.sp.jandira.roomtest2.R
import com.senai.sp.jandira.roomtest2.holder.ContatoHolder
import com.senai.sp.jandira.roomtest2.model.Contato

class ContatoAdapter: RecyclerView.Adapter<ContatoHolder>() {

    private var listaContatos = listOf<Contato>()

    fun carregarLista(novaLista: List<Contato>) {
        listaContatos = novaLista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.contato_recycler_layout, parent, false)

        return ContatoHolder(view)
    }

    override fun getItemCount() = listaContatos.size

    override fun onBindViewHolder(holder: ContatoHolder, position: Int) {
        holder.bind(listaContatos[position])
    }
}