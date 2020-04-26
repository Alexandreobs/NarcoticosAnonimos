package com.alexandreobsilva.a12passosnamauricio.model.pojos

import android.app.DownloadManager.COLUMN_ID
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "TEXTO_DIARIO")
class TextosDoDiario(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long = 0,
    @ColumnInfo(name = "texto_diario") var comrpoTexto: String,
    @ColumnInfo(name = "data_diario") var dataDoTexto: String,
    @ColumnInfo(name = "hora_diario") var horaDoTexto: String
) :
    Serializable {
}