/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Articulo;
import javax.persistence.Query;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author arevalo
 */
@RunWith(value = PowerMockRunner.class)
public class ArticuloFacadeTest extends AbstractTest<Articulo> {

    ArticuloFacade artfa;
    ArticuloFacade mock = mock(ArticuloFacade.class);

    @Override
    protected AbstractFacade<Articulo> getFacade() {
        return new ArticuloFacade();
    }

    @Override
    protected Articulo getEntity() {
        return new Articulo();
    }

    public final Query qq = mock(Query.class);

    @Test(expected = Exception.class)
    public void executeQueryTest() {
        when(this.em.createQuery(Matchers.any(String.class))).thenReturn(qq);
        int res = cut.executeQuery("SELECT A FROM " + entity.toString()).getResultList().size();
        assertEquals(0, res);

        res = cut.executeQuery(null).getResultList().size();
        assertEquals(0, res);
    }

    @Before
    public void inicio() throws Exception {
        whenNew(ArticuloFacade.class).withNoArguments().thenReturn(mock);
        artfa = new ArticuloFacade();
    }

    @Test
    public void getArticuloCompletoTest() {
        String id = "LGT456";
        System.out.println("1");
        String esperado = "Lapiz de grafitoFacelaMaster triangular";
        when(artfa.getArticuloCompleto(id)).thenReturn("Lapiz de grafitoFacelaMaster triangular");
        String resultado = artfa.getArticuloCompleto(id);
        verify(artfa).getArticuloCompleto(id);
        Assert.assertEquals(esperado, resultado);

    }
}
