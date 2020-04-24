package com.alexandreobsilva.a12passosnamauricio.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario

private const val NOME_BANCO_DE_DADOS = "vitoriaAnonima.db"
@Database(entities = arrayOf(TextosDoDiario::class), version = 1)
    abstract class MeuDataBaseRoom : RoomDatabase() {
        abstract fun diarioDao(): DiarioDAO

    companion object {

        private lateinit var db: MeuDataBaseRoom

        fun getInstance(context: Context): MeuDataBaseRoom {

            if (::db.isInitialized) return db

            db = Room.databaseBuilder(
                context,
                MeuDataBaseRoom::class.java,
                NOME_BANCO_DE_DADOS
            ).build()

            return db
        }
    }
}



