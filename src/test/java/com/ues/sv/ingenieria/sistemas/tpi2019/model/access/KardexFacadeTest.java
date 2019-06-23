/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public class KardexFacadeTest extends AbstractTest<Kardex> {

    KardexFacade kf;
    public final Query query = mock(Query.class);
    List<Kardex> lst = new ArrayList<>();

    @Override
    protected AbstractFacade<Kardex> getFacade() {
        return new KardexFacade();
    }

    @Override
    protected Kardex getEntity() {
        return new Kardex(1);
    }

    @Override
    public void init() {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        kf = new KardexFacade();
        lst.add(new Kardex());
        lst.add(new Kardex());
    }

    @Test
    public void getArticuloCompletoTest() {
        String tipo = "compra", sucursal = "1";
        boolean estado = true;
        Whitebox.setInternalState(kf, "em", em);
        Mockito.when(cut.executeQuery("SELECT k FROM Kardex k WHERE k.id" + tipo
                + " IS NOT NULL and k.id" + tipo + ".idSucursal LIKE '" + sucursal + "%' and k.id" + tipo + ".estado" + tipo + " = " + estado)).thenReturn(query);
        Mockito.when(query.setHint(QueryHints.REFRESH, HintValues.TRUE)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(lst);
        lstResultado = kf.filtrarKardex(tipo, sucursal, estado);
        assertEquals(2, lstResultado.size());
    }
}
