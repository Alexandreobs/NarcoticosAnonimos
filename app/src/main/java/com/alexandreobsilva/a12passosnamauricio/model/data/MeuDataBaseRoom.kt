package com.alexandreobsilva.a12passosnamauricio.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario

private const val NOME_BANCO_DE_DADOS = "vitoriaAnonima.db"

@Database(entities = [TextosDoDiario::class], version = 1)
abstract class MeuDataBaseRoom : RoomDatabase() {

    abstract fun diarioDao(): DiarioDAO

    companion object {
        private var instance: MeuDataBaseRoom? = null

        fun getDatabase(context: Context): MeuDataBaseRoom {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MeuDataBaseRoom::class.java,
                    NOME_BANCO_DE_DADOS
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as MeuDataBaseRoom
        }

        fun destroyInstance() {
            instance = null
        }
    }
}





