package com.site.eventos.repository

import com.site.eventos.entity.Evento
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EventoRepository:JpaRepository<Evento, UUID>{

}
