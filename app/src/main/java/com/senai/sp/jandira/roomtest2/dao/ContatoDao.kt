package com.senai.sp.jandira.roomtest2.dao

import androidx.room.*
import com.senai.sp.jandira.roomtest2.model.Contato

@Dao
interface ContatoDao {

    @Query("SELECT * FROM contato ORDER BY nome Desc")
    fun listartTodos() : List<Contato>

    @Query("SELECT * FROM contato WHERE id = :id ")
    fun listarPorId(id: Int): Contato

    @Insert
    fun salvar(contato: Contato)

    @Update
    fun atualizar(contato: Contato)

    @Delete
    fun deletar(contato: Contato)


}