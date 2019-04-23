/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Assert;
import static org.junit.Assert.assertNotNull;
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

    public AbstractFacade cut = getFacade();

    T entity;

    public AbstractBean bean;

    @Before
    public void init() {
        bean = getBean();
        entity = getEntity();
        Whitebox.setInternalState(cut, "em", em);
    }

    @Test
    public void crearBeanTest() {
        if (cut != null) {
            bean.crear();
            cut.create(entity);
            verify(em).persist(entity);
        }
    }

    @Test
    public void EditarBeanTest() {
        if (cut != null) {
            bean.editar();
            cut.edit(entity);
            verify(em).merge(entity);
        }
    }

    @Test
    public void EliminarBeanTest() {
        if (cut != null) {
            bean.eliminar();
        }
    }
    
//    @Test
//    public void llenarlistaBeanTest(){
//        Datos=bean.listaDatos;
//        System.out.println("Datos :"+ Datos);
//        List result =Collections.EMPTY_LIST;
//        if (cut!=null) {
//            System.out.println("paso pero fallara ");
//             result = cut.findAll();
//        }
//        Assert.assertEquals(Datos,result);
//    }
}
