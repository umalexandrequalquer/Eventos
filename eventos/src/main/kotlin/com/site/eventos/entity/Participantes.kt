package com.site.eventos.entity

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Participantes {
    @Id
    var id:UUID = UUID.randomUUID()
    val nome: String= ""
    val email: String=""
    @ManyToOne
    lateinit var evento: Evento
}