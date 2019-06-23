/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.BodegaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Bodega;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import junit.framework.Assert;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public class BodegaFacadeTest extends AbstractTest<Bodega> {
    
    BodegaFacade bf;
    Query query = Mockito.mock(Query.class);
    List<Bodega> lst = new ArrayList<>();
    List resul = new ArrayList<>();

    @Override
    protected AbstractFacade<Bodega> getFacade() {
        return new BodegaFacade();
    }

    @Override
    protected Bodega getEntity() {
        return new Bodega("1", "APA");
    }

    @Override
    public void init() {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        bf = new BodegaFacade();
        lst.add(new Bodega("1", "1"));
        lst.add(new Bodega("1", "1"));
        lst.add(new Bodega("1", "1"));
    }
    
    @Test
    public void bodegaPorSucursalTest(){
        Whitebox.setInternalState(bf, "em", em);
        Mockito.when(cut.executeQuery("SELECT b FROM Bodega b WHERE b.sucursal.idSucursal = :sucursal")).thenReturn(query);
        Mockito.when(query.setParameter(Matchers.any(String.class), Matchers.any(Object.class))).thenReturn(query);
        Mockito.when(query.setHint(QueryHints.REFRESH, HintValues.TRUE)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(lst);
        lstResultado = bf.bodegaPorSucursal("200IQ");
        Assert.assertEquals(3,lstResultado.size());
    }
    
    @Test
    public void findLikeTest(){
        Whitebox.setInternalState(bf, "em", em);
        Mockito.when(cut.executeQuery("SELECT t, b from Articulo t, Bodega b WHERE b.bodegaPK.idSucursal = :sucursal AND t.idArticulo = b.bodegaPK.idArticulo AND b.bodegaPK.idArticulo LIKE :like")).thenReturn(query);
        Mockito.when(query.setParameter(Matchers.any(String.class), Matchers.any(Object.class))).thenReturn(query);
        Mockito.when(query.setParameter(Matchers.any(String.class), Matchers.any(Object.class))).thenReturn(query);
        Mockito.when(query.setHint(QueryHints.REFRESH, HintValues.TRUE)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(lst);
        resul = bf.findLike("200IQ","2");
        Assert.assertEquals(3,resul.size());
    }
}
