package com.alexandreobsilva.a12passosnamauricio.model.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario

@Dao
interface DiarioDAO {

    @Query("SELECT * FROM textosdodiario")
    fun getAll(): List<TextosDoDiario>

    @Query("SELECT * FROM textosdodiario WHERE uid IN (:textosIds)")
    fun loadAllByIds(textosIds: IntArray): List<TextosDoDiario>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): TextosDoDiario

    @Insert
    fun insertAll(vararg textos: TextosDoDiario)

    @Delete
    fun delete(texto: TextosDoDiario)
}