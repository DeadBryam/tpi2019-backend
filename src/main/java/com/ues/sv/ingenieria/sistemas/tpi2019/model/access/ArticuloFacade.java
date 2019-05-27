/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bryan
 */
@Stateless
public class ArticuloFacade extends AbstractFacade<Articulo> {

    @PersistenceContext(unitName = "com.ues.sv.ingenieria.sistemas.tpi2019_inventarioLibreria_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticuloFacade() {
        super(Articulo.class);
    }
    
    public String getArticuloCompleto(String id){
        return executeQuery("SELECT CONCAT(m.idTipoArticulo.tipoArticulo, \" \", m.idMarca.marca, \", \", m.articulo ) FROM Articulo m WHERE m.idArticulo = '"+id+"'")
                .getResultList().get(0).toString();
    }
    
    public List<Articulo> findLike(String like){
        return executeQuery("SELECT a FROM Articulo a WHERE lower(a.articulo) LIKE :like")
                .setParameter("like", "%"+like+"%").getResultList();
    }
}
