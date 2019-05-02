/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
                throw new NullPointerException();
            }
        } catch (Exception e) {
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
                throw new NullPointerException("");
            }
        } catch (Exception e) {
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
                throw new NullPointerException("");
            }
        } catch (Exception e) {
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
            if (entityClass != null && id != null) {
                return getEntityManager().find(entityClass, id);
            } else {
                throw new NullPointerException("");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<T> findAll() {
        try {
            if (entityClass != null && getEntityManager() != null) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                cq.select(cq.from(entityClass));
                return getEntityManager().createQuery(cq).getResultList();
            } else {
                return Collections.EMPTY_LIST;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<T> findRange(int primero, int ultimo) {
        try {
            if (entityClass != null && getEntityManager() != null && (primero < ultimo)) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                cq.select(cq.from(entityClass));
                javax.persistence.Query q = getEntityManager().createQuery(cq);
                q.setMaxResults(ultimo);
                q.setFirstResult(primero);
                return q.getResultList();
            } else {
                throw new NullPointerException("");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public int count() {
          try {
            if (getEntityManager()!=null && entityClass!=null) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
                cq.select(getEntityManager().getCriteriaBuilder().count(rt));
                javax.persistence.Query q = getEntityManager().createQuery(cq);
                return ((Long) q.getSingleResult()).intValue();
            }else{
                throw new NullPointerException();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Query executeQuery(String query){
        if (getEntityManager()!=null && query!=null) {
           return getEntityManager().createQuery(query);
        }else{
            return null;
        }
    }
    
}
