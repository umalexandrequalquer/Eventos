package com.site.eventos.services

import com.site.eventos.entity.Evento
import com.site.eventos.entity.Participantes
import com.site.eventos.repository.EventoRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EventoService(private val eventoRepository: EventoRepository) {

    fun mostrarTodosOsEventos(): List<Evento> {
        return eventoRepository.findAll().toList()
    }
    fun criarEvento(evento: Evento): Evento {
        return eventoRepository.save(evento)
    }

    fun adicionarParticipante(evento:  UUID, participantes: Participantes): Evento {
        val evento = eventoRepository.findById(evento)
            .orElseThrow { throw RuntimeException("Evento não encontrado")}
       participantes.evento = evento
        evento.participantes.add(participantes)
        return eventoRepository.save(evento)
    }

    fun removerParticipante(eventId: UUID, participanteId: UUID) {
        val evento = eventoRepository.findById(eventId)
            .orElseThrow { throw RuntimeException("Evento não encontrado") }
        val participante = evento.participantes.firstOrNull { it.id == participanteId }
            ?: throw RuntimeException("Participante não encontrado no evento")
        evento.participantes.remove(participante)
        eventoRepository.save(evento)
    }
}
