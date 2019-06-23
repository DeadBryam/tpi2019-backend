/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author bryan
 */
@Stateless
public class KardexFacade extends AbstractFacade<Kardex> {

    @PersistenceContext(unitName = "com.ues.sv.ingenieria.sistemas.tpi2019_inventarioLibreria_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KardexFacade() {
        super(Kardex.class);
    }
    
    public List<Kardex> filtrarKardex(String tipo, String sucursal, boolean estado){
        return executeQuery("SELECT k FROM Kardex k WHERE k.id"+tipo
                +" IS NOT NULL and k.id"+tipo+".idSucursal LIKE '"+sucursal+"%' and k.id"+tipo+".estado"+tipo+" = "+estado)
                .setHint(QueryHints.REFRESH, HintValues.TRUE).getResultList();
    }
    
}
