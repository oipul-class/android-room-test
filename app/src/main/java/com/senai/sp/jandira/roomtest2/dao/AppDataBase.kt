package com.senai.sp.jandira.roomtest2.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.senai.sp.jandira.roomtest2.model.Contato

@Database(entities = [Contato::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun contatoDao(): ContatoDao
}