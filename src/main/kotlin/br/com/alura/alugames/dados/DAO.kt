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
}