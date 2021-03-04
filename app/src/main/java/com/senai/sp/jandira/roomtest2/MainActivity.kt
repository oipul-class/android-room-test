package com.senai.sp.jandira.roomtest2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.senai.sp.jandira.roomtest2.adapter.ContatoAdapter
import com.senai.sp.jandira.roomtest2.dao.AppDataBase
import com.senai.sp.jandira.roomtest2.dao.Database
import com.senai.sp.jandira.roomtest2.model.Contato

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonNovoContato: ImageButton
    private lateinit var editNome: EditText
    private lateinit var editTelefone: EditText
    private lateinit var buttonSalvar: Button
    private lateinit var buttonCancelar: Button
    private lateinit var dialog: AlertDialog
    private lateinit var recyclerContato: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNovoContato = findViewById(R.id.button_novo_contato)
        buttonNovoContato.setOnClickListener(this)

        recyclerContato = findViewById(R.id.recycler_contatos)

        exibirContatos()
    }

    override fun onClick(v: View) {

        if (v.id == R.id.button_novo_contato) {
            abrirCadastroContato()
        }
        else if (v.id == R.id.button_cancelar) {
            dialog.dismiss()
        } else if (v.id == R.id.button_salvar) {
            salvarContato()
        } else {
            exibirContatos()
        }

    }

    private fun exibirContatos() {
        val db = Room.databaseBuilder(
            this,
            AppDataBase::class.java,
            "dbContato"
        ).allowMainThreadQueries().build()

        val contatoDao = db.contatoDao()

        val adapter = ContatoAdapter()

        val contatos = contatoDao.listartTodos()

        recyclerContato.layoutManager = LinearLayoutManager(this)

        adapter.carregarLista(contatos)

        recyclerContato.adapter = adapter
    }

    private fun salvarContato() {
        var contato = Contato(
            nomeContato = editNome.text.toString(),
            telefoneContato = editTelefone.text.toString()
        )


        val contatoDao = Database.getDatabase(this).contatoDao()
        contatoDao.salvar(contato)

        exibirContatos()
        dialog.dismiss()
    }

    private fun abrirCadastroContato() {
        val alertDialog = AlertDialog.Builder(this)

        val inflater = layoutInflater

        val view = inflater.inflate(R.layout.cadastro_contato_dialog, null)

        alertDialog.setView(view)

        editNome = view.findViewById(R.id.edit_nome)
        editTelefone = view.findViewById(R.id.edit_telefone)
        buttonSalvar = view.findViewById(R.id.button_salvar)
        buttonSalvar.setOnClickListener(this)

        buttonCancelar = view.findViewById(R.id.button_cancelar)
        buttonCancelar.setOnClickListener(this)

        dialog = alertDialog.create()
        dialog.setCancelable(false)
        dialog.show()

    }
}