/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;
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
@Path("sucursal")
public class SucursalREST {

    @EJB
    SucursalFacade facade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(
            @QueryParam("first") @DefaultValue("0") int first,
            @QueryParam("size") @DefaultValue("10") int size) {
        return Response.ok(facade.findRange(first, size))
                .header("Total-Reg", facade.count())
                .header("Page-Reg", facade.findRange(first, size).size())
                .build();
    }
    
    @GET
    @Path("/{idsucursal}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(
            @PathParam("idsucursal") String id) {
        return Response.ok(facade.findById(id))
                .header("Registro Encontrado", 1)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Sucursal reg) {
        if (reg == null) {
            return Response.status(400, "Missing data.")
                    .header("Missing data.", "")
                    .build();
        }

        reg = facade.create(reg);
        return Response.status(Response.Status.CREATED)
                .entity(reg)
                .header("Registro creado", reg)
                .build();
    }

}
