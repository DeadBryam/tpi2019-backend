/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.web;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Bodega;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.BodegaPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author arevalo
 */
@Stateless
@Path("bodega")
public class BodegaFacadeREST extends AbstractFacade<Bodega> {
    @PersistenceContext(unitName = "com.ues.sv.ingenieria.sistemas.tpi2019_inventarioLibreria_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private BodegaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idArticulo=idArticuloValue;idSucursal=idSucursalValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.ues.sv.ingenieria.sistemas.tpi2019.model.data.BodegaPK key = new com.ues.sv.ingenieria.sistemas.tpi2019.model.data.BodegaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idArticulo = map.get("idArticulo");
        if (idArticulo != null && !idArticulo.isEmpty()) {
            key.setIdArticulo(idArticulo.get(0));
        }
        java.util.List<String> idSucursal = map.get("idSucursal");
        if (idSucursal != null && !idSucursal.isEmpty()) {
            key.setIdSucursal(idSucursal.get(0));
        }
        return key;
    }

    public BodegaFacadeREST() {
        super(Bodega.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Bodega entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Bodega entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.ues.sv.ingenieria.sistemas.tpi2019.model.data.BodegaPK key = getPrimaryKey(id);
        super.remove(super.findById(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Bodega find(@PathParam("id") PathSegment id) {
        com.ues.sv.ingenieria.sistemas.tpi2019.model.data.BodegaPK key = getPrimaryKey(id);
        return super.findById(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Bodega> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Bodega> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(from, to);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
