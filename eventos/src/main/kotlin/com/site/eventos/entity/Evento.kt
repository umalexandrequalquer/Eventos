package com.site.eventos.entity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Evento {
    @Id
    val id:UUID = UUID.randomUUID()
    var name:String = ""
    var description:String =""
}