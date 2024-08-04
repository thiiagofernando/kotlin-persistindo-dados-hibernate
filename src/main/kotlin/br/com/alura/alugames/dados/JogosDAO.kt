package br.com.alura.alugames.dados
import br.com.alura.alugames.modelo.Jogo

class JogosDAO {
    fun getJogos(): List<Jogo> {
        val manager = Banco.getEntityManager()
        try {
            val query = manager.createQuery("FROM Jogo", Jogo::class.java)
            return query.resultList
        }finally {
            manager.close()
        }
    }
}