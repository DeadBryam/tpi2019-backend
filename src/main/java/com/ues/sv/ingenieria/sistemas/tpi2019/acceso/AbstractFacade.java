/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author bryan
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    /**
     *
     * @param entity
     */
    public void create(T entity) {
        try {
            if (getEntityManager() != null && entity != null) {
                getEntityManager().persist(entity);
            } else {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "EntityManager o Entity son nulos");
                throw new NullPointerException("EntityManager o Entity son nulos");
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    /**
     *
     * @param entity
     */
    public void edit(T entity) {
        try {
            if (getEntityManager() != null && entity != null) {
                getEntityManager().merge(entity);
            } else {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "EntityManager o Entity son nulos");
                throw new NullPointerException("EntityManager o Entity son nulos");
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    /**
     *
     * @param entity
     */
    public void remove(T entity) {
        try {
            if (getEntityManager() != null && entity != null) {
                getEntityManager().remove(getEntityManager().merge(entity));
            } else {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "EntityManager o Entity son nulos");
                throw new NullPointerException("EntityManager o Entity son nulos");
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public T findById(Object id) {
        try {
            if (id != null) {
                return getEntityManager().find(entityClass, id);
            }
        } catch (Exception ex) {
            System.out.println("ex: " + ex);
            throw ex;
        }
        return null;
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int primero, int ultimo) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(ultimo);
        q.setFirstResult(primero);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
        
    }

}
