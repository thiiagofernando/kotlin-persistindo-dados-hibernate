package br.com.alura.alugames.principal
import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.modelo.Jogo

fun main(){
    val manager = Banco.getEntityManager()
    val jogoDao = JogosDAO(manager)

    //Adicionar Um registro novo
    //val jogoNovo = Jogo("STAR WARS: Galaxy of Heroes","https://media.contentapi.ea.com/content/dam/eacom/star-wars/images/2019/10/sw-inline-media-franchise-hub-swgoh.png.adapt.crop16x9.1455w.png",332.99,"Viva seus sonhos de STAR WARS™ e lute em locais icônicos com seus heróis e heroínas favoritos, do lado sombrio e do lado da luz, para se tornar mestre da galáxia.")
    //jogoDao.adicionar(jogoNovo)

    //obter um registro por id
    //val jogoRecuperado = jogoDao.getPorId(3)
    //println(jogoRecuperado)

    //excluir um registro por id
    //jogoDao.excluir(4)

     //Atualizar um registro
    //jogoRecuperado.preco = 123.78
    //jogoDao.atualizar(jogoRecuperado)

     //Buscar todos os reguistros no banco
     val listJogos:List<Jogo> = jogoDao.getLista()
     println(listJogos)

     manager.close()
}