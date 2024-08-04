package br.com.alura.alugames.dados
import javax.persistence.*

@Entity
@Table(name = "jogos")
class JogoEntity(
    val titulo: String= "Titulo do Jogo",
    val capa: String = "Capa do Jogo",
    val preco: Double = 0.0,
    val descricao: String? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0) {
}