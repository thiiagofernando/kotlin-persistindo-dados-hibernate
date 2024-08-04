package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(protected val manager: EntityManager, protected val entityType: Class<TEntity>) {
    abstract fun toEntity(objeto:TModel):TEntity
    abstract  fun toModel(entity:TEntity):TModel

    open fun getLista():List<TModel>{
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map { entity -> toModel(entity) }
    }

    open fun adicionar(item:TModel){
        val entity = toEntity(item)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun getPorId(id:Int): TModel{
        val query = manager.createQuery("FROM ${entityType.simpleName} where id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        return toModel(entity)
    }
    open fun excluir(id:Int){
        val query = manager.createQuery("FROM ${entityType.simpleName} where id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }

    open fun atualizar(item:TModel){
        val entity = toEntity(item)
        manager.transaction.begin()
        manager.merge(entity)
        manager.transaction.commit()
    }
}