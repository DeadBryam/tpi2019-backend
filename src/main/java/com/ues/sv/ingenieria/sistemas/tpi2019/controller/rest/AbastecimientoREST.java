/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.DistribuidorFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Distribuidor;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author arevalo
 */
@Stateless
@Path("sucursal/{idsucursal}/distribuidor")
public class AbastecimientoREST {

    @EJB
    DistribuidorFacade distribuidorFacade;
    @EJB
    SucursalFacade sucursalFacade;
    @PathParam("idsucursal")
    String idSucursal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(
            @QueryParam("first") @DefaultValue("0") int first,
            @QueryParam("size") @DefaultValue("10") int size) {
        if (sucursalFacade.sucursalExists(idSucursal)) {
            return Response.ok(distribuidorFacade.findRange(first, size))
                    .header("Total-Reg", distribuidorFacade.count())
                    .header("Page-Reg", distribuidorFacade.findRange(first, size).size())
                    .build();
        }
        return Response.status(404, "Unknown sucursal.")
                .build();
    }
    
    @GET
    @Path("/{iddistribuidor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(
            @PathParam("iddistribuidor") String id) {
        if (sucursalFacade.sucursalExists(idSucursal)) {
            return Response.ok(distribuidorFacade.findById(id))
                    .build();
        }
        return Response.status(404, "Unknown sucursal.")
                .build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Distribuidor reg) {
        if (reg != null && sucursalFacade.sucursalExists(idSucursal)) {
            reg = distribuidorFacade.create(reg);
            return Response.status(Response.Status.CREATED)
                    .entity(reg)
                    .build();
        } else if (!sucursalFacade.sucursalExists(idSucursal)) {
            return Response.status(404, "Unknown sucursal.")
                    .build();
        }
        return Response.status(400, "Missing data.")
                .build();
    }

    @POST
    @Path("/{idcaja}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCompra() {
        return Response.status(404, "coming soon.")
                .build();
    }
}
