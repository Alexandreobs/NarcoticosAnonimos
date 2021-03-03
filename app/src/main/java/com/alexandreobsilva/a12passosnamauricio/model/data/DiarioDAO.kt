package com.alexandreobsilva.a12passosnamauricio.model.data

import android.app.DownloadManager.COLUMN_ID
import androidx.lifecycle.LiveData
import androidx.room.*
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario

@Dao
interface DiarioDAO {


    @Insert
    fun insertAll(vararg textos: TextosDoDiario)

    @Update
    fun update(texto: TextosDoDiario)

    @Delete
    fun delete(vararg texto: TextosDoDiario)

    @Query("SELECT * FROM TEXTO_DIARIO")
    fun getAll(): List<TextosDoDiario>

    @Query("SELECT * FROM TEXTO_DIARIO WHERE $COLUMN_ID = :textosIds")
    fun loadAllByIds(textosIds: Long): LiveData<TextosDoDiario>

    @Query(""" SELECT * FROM TEXTO_DIARIO
         WHERE $COLUMN_ID LIKE :query ORDER BY $COLUMN_ID """)
    fun search(query: String): LiveData<List<TextosDoDiario>>
}