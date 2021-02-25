package com.senai.sp.jandira.roomtest2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //tipo que ela ira ser, neste caso o @Entity ira fazer ela ser uma entidade/tabela
data class Contato(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "nome") var nomeContato: String?,
    @ColumnInfo(name = "telefone") var telefoneContato: String
) {

}