/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.BodegaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author lordbryan
 */
@Stateless
@Path("sucursal/{idsucursal}/bodega")
public class BodegaRest {

    @EJB
    BodegaFacade bodegaFacade;
    @EJB
    SucursalFacade sucursalFacade;
    @PathParam("idsucursal")
    String idSucursal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findLike(
            @QueryParam("filter") @DefaultValue("") String filter) {
        if (sucursalFacade.sucursalExists(idSucursal)) {
            return Response.ok(bodegaFacade.findLike(idSucursal, filter))
                    .header("Total-Reg", bodegaFacade.findLike(idSucursal, filter).size())
                    .build();
        }
        return Response.status(404, "Unknown sucursal.")
                .build();
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        if (sucursalFacade.sucursalExists(idSucursal)) {
            return Response.ok(bodegaFacade.bodegaPorSucursal(idSucursal))
                    .header("Total-Reg", bodegaFacade.bodegaPorSucursal(idSucursal).size())
                    .build();
        }
        return Response.status(404, "Unknown sucursal.")
                .build();
    }

}
