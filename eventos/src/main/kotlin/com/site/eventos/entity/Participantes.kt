package com.site.eventos.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Participantes {
    @Id
    var id:UUID = UUID.randomUUID()
    @Column(unique = true)
    var nome: String= ""
    var email: String=""

    @ManyToOne()
    @JsonIgnore
    lateinit var evento: Evento
}