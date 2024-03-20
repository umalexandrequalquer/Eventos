package com.site.eventos.entity
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.UUID

@Entity
class Evento {
    @Id
    var Id:UUID = UUID.randomUUID()
    val nome: String = ""
    val local: String?= null
    val descricao: String?= null
    @OneToMany(mappedBy = "evento", cascade = [CascadeType.ALL], orphanRemoval = true)
    var participantes: MutableList<Participantes> = ArrayList()

}