/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.web;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author arevalo
 */
@Stateless
@Path("articulo")
public class ArticuloFacadeREST extends AbstractFacade<Articulo> {
    @PersistenceContext(unitName = "com.ues.sv.ingenieria.sistemas.tpi2019_inventarioLibreria_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ArticuloFacadeREST() {
        super(Articulo.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Articulo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") String id, Articulo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.findById(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Articulo find(@PathParam("id") String id) {
        return super.findById(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Articulo> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("prueba")
    @Produces({"application/xml","application/json"})
    public Response Find(){
        List<Articulo> articulos=super.findAll();
        System.out.println("Articulos: "+articulos);
        return Response.ok(articulos,MediaType.APPLICATION_JSON).build();
                
    }
    
    
    
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Articulo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
