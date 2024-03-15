package com.site.eventos.web.controller

import com.site.eventos.entity.Evento
import com.site.eventos.entity.Participantes
import com.site.eventos.services.EventoService
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController()
@RequestMapping("/event")
class EventoController (private var eventoService: EventoService){

    @GetMapping("/todos-eventos")
    fun mostrarTodosOsEventos():List<Evento> = eventoService.mostrarTodosOsEventos()



    @PostMapping("/criar-evento")
    fun criarEvento(@RequestBody evento:Evento):Evento{
        return  eventoService.criarEvento(evento)

    }
    @PostMapping("/{eventoId}/participantes")
    fun adicionarParticipante(@PathVariable eventoId: UUID, @RequestBody participante: Participantes): Evento {
        return eventoService.adicionarParticipante(eventoId, participante)
    }


}