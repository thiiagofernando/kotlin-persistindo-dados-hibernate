package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "Gamer")
class GamerEntity(
    val nome: String = "Nome do Gamer",
    val email: String = "E-mail do Gamer",
    val dataNascimento:String = "",
    val usuario:String = "",
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0) {
}