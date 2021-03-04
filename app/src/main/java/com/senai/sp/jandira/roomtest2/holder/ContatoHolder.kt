package com.senai.sp.jandira.roomtest2.holder

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.senai.sp.jandira.roomtest2.model.Contato
import kotlinx.android.synthetic.main.contato_recycler_layout.view.*

class ContatoHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private var textId = view.text_id
    private var textNome = view.text_nome
    private var textTelefone = view.text_telefone

    fun bind(contato: Contato) {
        textId.text = contato.id.toString()
        textNome.text = contato.nomeContato
        textTelefone.text = contato.telefoneContato

        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(itemView.context, textId.text, Toast.LENGTH_SHORT).show()

    }


}
