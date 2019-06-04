/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Any;
import javax.persistence.Query;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author arevalo
 */
@RunWith(value = PowerMockRunner.class)
public class ArticuloFacadeTest extends AbstractTest<Articulo> {

    ArticuloFacade af;
    public final Query query = mock(Query.class);
    List lst = new ArrayList<>();

    @Override
    protected AbstractFacade<Articulo> getFacade() {
        return new ArticuloFacade();
    }

    @Override
    protected Articulo getEntity() {
        return new Articulo();
    }

    @Test(expected = Exception.class)
    public void executeQueryTest() {
        when(this.em.createQuery(Matchers.any(String.class))).thenReturn(query);
        int res = cut.executeQuery("SELECT A FROM " + entity.toString()).getResultList().size();
        assertEquals(0, res);

        res = cut.executeQuery(null).getResultList().size();
        assertEquals(0, res);
    }

    @Override
    public void init() {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        af = new ArticuloFacade();
        lst.add("Boligrafo");
    }
    
    @Test
    public void getArticuloCompletoTest() {
        String resultado;
        String id = "200IQ";
        Whitebox.setInternalState(af, "em", em);
        Mockito.when(cut.executeQuery("SELECT CONCAT(m.idTipoArticulo.tipoArticulo, \" \", m.idMarca.marca, \", \", m.articulo ) FROM Articulo m WHERE m.idArticulo = '"+id+"'")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(lst);
        resultado = af.getArticuloCompleto(id);
        assertEquals("Boligrafo", resultado);
    }
    
    @Test
    public void findLikeTest(){
        Whitebox.setInternalState(af, "em", em);
        when(cut.executeQuery("SELECT a FROM Articulo a WHERE a.idArticulo LIKE :like")).thenReturn(query);
        when(query.setParameter(Matchers.any(String.class), Matchers.any(Object.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(lst);
        
        assertEquals(1, af.findLike("200IQ").size());
        
    }
}
