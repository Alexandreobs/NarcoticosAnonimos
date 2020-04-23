package com.alexandreobsilva.a12passosnamauricio.model.pojos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class TextosDoDiario(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "texto_diario") var comrpoTexto: String,
    @ColumnInfo(name = "data_diario") var dataDoTexto: String,
    @ColumnInfo(name = "hora_diario") var horaDoTexto: String
) :
    Serializable {
}