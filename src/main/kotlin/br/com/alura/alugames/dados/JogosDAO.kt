package br.com.alura.alugames.dados
import br.com.alura.alugames.dados.Banco.obterConexao
import br.com.alura.alugames.modelo.Jogo

class JogosDAO {
    fun getJogos(): List<Jogo> {
        var listaJogos = mutableListOf<Jogo>()
        var conexao = obterConexao()
        if (conexao != null) {
            try {
                var statement = conexao.createStatement()
                val resultado  = statement.executeQuery("select * from jogos")

                while (resultado.next()){
                    val id = resultado.getInt("id")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val titulo = resultado.getString("titulo")
                    val preco = resultado.getDouble("preco")

                    val jogo = Jogo(titulo,capa,preco,descricao,id)
                    listaJogos.add(jogo)
                }
                statement.close()
            }finally {
                conexao.close()
            }
        }

        return listaJogos
    }

    fun adicionarJogo(jogoNovo: Jogo) {
        val conexao = obterConexao()
        val insert =  "INSERT INTO Alugames.jogos (capa, descricao, preco, titulo) VALUES(?,?,?,?);"
        if(conexao != null){
            try {
                val statement = conexao.prepareStatement(insert)
                statement.setString(1, jogoNovo.capa)
                statement.setString(2, jogoNovo.descricao)
                statement.setDouble(3, jogoNovo.preco)
                statement.setString(4, jogoNovo.titulo)
                statement.executeUpdate()
                statement.close()
            }finally {
                conexao.close()
            }
        }
    }
}