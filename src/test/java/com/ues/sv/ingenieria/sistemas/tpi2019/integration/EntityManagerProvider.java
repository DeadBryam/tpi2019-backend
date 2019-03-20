/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author bryan
 */
public class EntityManagerProvider implements TestRule{
    
    public static EntityManagerProvider emp;
    private final EntityTransaction transaction;
    private final EntityManager em;
    private final AbstractFacade facade;

    private EntityManagerProvider(String name, AbstractFacade facade) {
        this.facade = facade;
        this.em = Persistence.createEntityManagerFactory(name).createEntityManager();
        Whitebox.setInternalState(facade, "em", this.em);
        this.transaction = this.em.getTransaction();
    }
    
    public static EntityManagerProvider getInstance(String name, AbstractFacade facade){
        return new EntityManagerProvider(name, facade);
    }

    @Override
    public Statement apply(Statement stmnt, Description d) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                getEm().clear();
                getEm().close();
            }
        };
    }
    
        public static EntityManagerProvider getEmp() {
        return emp;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }

    public EntityManager getEm() {
        return em;
    }

    public AbstractFacade getFacade() {
        return facade;
    }
    
    
}
