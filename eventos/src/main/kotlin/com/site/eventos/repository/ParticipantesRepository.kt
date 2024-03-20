package com.site.eventos.repository

import com.site.eventos.entity.Participantes
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ParticipantesRepository:JpaRepository<Participantes,UUID> {
    fun findByNome(nome: String): Participantes?

}