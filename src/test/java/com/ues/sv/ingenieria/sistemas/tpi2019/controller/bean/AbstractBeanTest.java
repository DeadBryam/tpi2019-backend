/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.AbstractBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author arevalo
 * @param <T>
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractBeanTest<T> implements Serializable {

    List Datos;

    public abstract T getEntity();

    protected abstract AbstractFacade<T> getFacade();

    protected abstract AbstractBean<T> getBean();
    @Mock
    private EntityManager em;

    public AbstractFacade cut=getFacade();
    
    T entity;

    @Before
    public void init() {
        entity = getEntity();
         Whitebox.setInternalState(cut, "em", em);
    }

    @Test
    public void crearBeanTest() {
        if (cut != null) {
            getBean().crear();
            cut.create(entity);
            verify(em).persist(entity);
        }else{
            System.out.println("nada");
        }
    }

    @Test
    public void EditarBeanTest() {
        if (cut != null) {
            getBean().editar();
            cut.edit(entity);
            verify(em).merge(entity);
        }
    }

    @Test
    public void EliminarBeanTest() {
        if (cut != null) {
            getBean().eliminar();
        }
    }

//    @Test
//    public void llenarlistaBeanTest() {
//        Datos = cut.findAll();
//        System.out.println("Datos "+Datos);
//        int fad=Mockito.spy(cut.findAll().size());
//        System.out.println("cut "+cut);
//        
//        System.out.println("fad: "+fad);
//        List result = Collections.EMPTY_LIST;
//        if (cut != null) {
//            System.out.println("paso pero fallara ");
//            result = cut.findAll();
//        }
//        Assert.assertEquals(Datos, result);
//    }
    
    
}
