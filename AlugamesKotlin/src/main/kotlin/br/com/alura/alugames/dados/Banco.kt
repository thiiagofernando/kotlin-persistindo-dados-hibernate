package br.com.alura.alugames.dados
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
    fun obterConexao(): Connection?{
        return  try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/Alugames","thiago","Mudar@1234")
        }catch (e: SQLException){
            e.printStackTrace()
            null
        }
    }
}