/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Articulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Marca;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Medida;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.TipoArticulo;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
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
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 *
 * @author arevalo
 */
@RunWith(value = PowerMockRunner.class)
public class ArticuloFacadeTest extends AbstractTest<Articulo> {

  //  ArticuloFacade mock ;

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

//    @Before
//    public void inicio(){
//        mock=new ArticuloFacade();
//        Whitebox.setInternalState(mock, "em", em);
//        when(mock.executeQuery("1").getResultList().get(0).toString()).thenReturn("1");
//        when(mock.getArticuloCompleto("0")).thenReturn("1");
//    }
//
//    @Test
//    public void getArticuloCompletoTest() {
//       Articulo ar= new Articulo("1", "Lapiz de grafito", BigDecimal.ZERO);
//       cut.create(ar);
//       String esperado=mock.executeQuery("1").getResultList().get(0).toString();
//        String resultado= mock.getArticuloCompleto("0");
//        assertEquals( esperado,resultado);
//
//    }
}
