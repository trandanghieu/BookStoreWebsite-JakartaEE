package com.bookstore.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;


public class JpaDAO<E> {
    protected EntityManager entityManager;

    public JpaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public E create(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public E update(E entity) {
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public E find(Class<E> type, Object id) {
        E entity = entityManager.find(type, id);
        if (entity != null) {
            entityManager.refresh(entity);
        }

        return entity;
    }

    public void delete(Class<E> type, Object id) {
        entityManager.getTransaction().begin();

        Object reference = entityManager.getReference(type, id);
        if (reference != null) {
            entityManager.remove(reference);
        }
        entityManager.getTransaction().commit();
    }
    public List<E> findWithNamedQuery(String queryName){
        Query query = entityManager.createNamedQuery(queryName);
        return query.getResultList();
    }
    public long countWithNamedQuery(String queryName){
        Query query = entityManager.createNamedQuery(queryName);
        return (long) query.getSingleResult();
    }

}
