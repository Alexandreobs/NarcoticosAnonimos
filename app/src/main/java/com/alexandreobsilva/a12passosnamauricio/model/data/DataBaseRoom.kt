package com.alexandreobsilva.a12passosnamauricio.model.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario

class DataBaseRoom {

    @Database(entities = arrayOf(TextosDoDiario::class), version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun diarioDao(): DiarioDAO
    }



}