package com.site.eventos.services

import com.site.eventos.entity.Evento
import com.site.eventos.entity.Participantes
import com.site.eventos.repository.EventoRepository
import com.site.eventos.repository.ParticipantesRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EventoService(private val eventoRepository: EventoRepository, private val participantesRepository: ParticipantesRepository) {

    fun mostrarTodosOsEventos(): List<Evento> {
        return eventoRepository.findAll().toList()

    }
    fun criarEvento(evento: Evento): Evento {
        return eventoRepository.save(evento)
    }

    fun adicionarParticipante(eventoId: UUID, participante: Participantes) {
        val evento = eventoRepository.findById(eventoId)
            .orElseThrow { RuntimeException("Evento não encontrado") }


        val participanteExistente = participantesRepository.findByNome(participante.nome)

        if (participanteExistente != null) {
            throw RuntimeException("Já existe um participante com o mesmo nome.")
        }


        participante.evento = evento
        evento.participantes.add(participante)

        // Salvando o evento, o participante será salvo por cascata
        eventoRepository.save(evento)
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
