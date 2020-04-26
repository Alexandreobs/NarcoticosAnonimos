package com.alexandreobsilva.a12passosnamauricio.model.data.repositorys

import androidx.lifecycle.LiveData
import com.alexandreobsilva.a12passosnamauricio.model.data.MeuDataBaseRoom
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario

class RoomRepositorory(
    meuDataBaseRoom: MeuDataBaseRoom
) : DiarioRepository {
    private val DiarioDAO = meuDataBaseRoom.diarioDao()

    override fun save(textos: TextosDoDiario) {
        if (textos.id == 0L) {
            val id = DiarioDAO.insertAll(textos)
            textos.id = id
        } else {
            DiarioDAO.update(textos)
        }
    }

    override fun remove(vararg textosDoDiario: TextosDoDiario) {
        DiarioDAO.delete(*textosDoDiario)
    }

    override fun diarioById(id: Long): LiveData<TextosDoDiario> {
        return DiarioDAO.loadAllByIds(id)
    }

    override fun search(term: String): LiveData<List<TextosDoDiario>> {
        return DiarioDAO.search(term)
    }
}
