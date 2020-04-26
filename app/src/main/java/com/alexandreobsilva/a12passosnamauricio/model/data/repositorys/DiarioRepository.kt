package com.alexandreobsilva.a12passosnamauricio.model.data.repositorys

import androidx.lifecycle.LiveData
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario

interface DiarioRepository {

    fun save(textosDoDiario: TextosDoDiario)

    fun remove(vararg textosDoDiario: TextosDoDiario)

    fun diarioById(id: Long): LiveData<TextosDoDiario>

    fun search(term: String): LiveData<List<TextosDoDiario>>
}