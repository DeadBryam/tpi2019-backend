/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CajaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Caja;
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
@Path("sucursal/{idsucursal}/caja")
public class FacturacionRest {

    @EJB
    CajaFacade cajaFacade;
    @EJB
    SucursalFacade sucursalFacade;
    @PathParam("idsucursal")
    String idSucursal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRange(
            @QueryParam("first") @DefaultValue("0") int first,
            @QueryParam("size") @DefaultValue("10") int size) {
        if (sucursalFacade.sucursalExists(idSucursal)) {
            return Response.ok(cajaFacade.findRange(first, size))
                    .header("Total-Reg", cajaFacade.count())
                    .header("Page-Reg", cajaFacade.findRange(first, size).size())
                    .build();
        }
        return Response.status(404, "Unknown sucursal.")
                .build();

    }
    
    @GET
    @Path("/{idcaja}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(
            @PathParam("idcaja") int id) {
        if (sucursalFacade.sucursalExists(idSucursal)) {
            return Response.ok(cajaFacade.findById(id))
                    .build();
        }
        return Response.status(404, "Unknown sucursal.")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Caja reg) {
        if (reg != null && sucursalFacade.sucursalExists(idSucursal)) {
            reg = cajaFacade.create(reg);
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
    public Response addVenta() {
        return Response.status(404, "coming soon.")
                .build();
    }

}
