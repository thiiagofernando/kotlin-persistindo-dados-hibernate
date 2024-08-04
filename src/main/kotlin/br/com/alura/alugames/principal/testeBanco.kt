package br.com.alura.alugames.principal
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.modelo.Jogo

fun main(){
//    val jogoNovo = Jogo("Left 4 Dead","https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/500/header.jpg?t=1718138026",32.99," Left 4 Dead, um jogo cooperativo de ação e terror para computador e Xbox 360")
    val jogoDao = JogosDAO()
//    jogoDao.adicionarJogo(jogoNovo);

    var listJogos:List<Jogo> = jogoDao.getJogos()
    println(listJogos)
}