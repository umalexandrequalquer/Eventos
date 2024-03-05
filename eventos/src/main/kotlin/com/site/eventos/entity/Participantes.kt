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
    var nameParticipante:String = ""

    @ManyToOne
    @JoinColumn(name = "Evento_id")
    lateinit var evento:Evento

}