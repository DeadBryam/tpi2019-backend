/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
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
@Path("sucursal/{idsucursal}/historial")
public class HistorialRest {
    
    @EJB
    KardexFacade kardexFacade;
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
            return Response.ok(kardexFacade.findRange(first, size))
                    .header("Total-Reg", kardexFacade.count())
                    .header("Page-Reg", kardexFacade.findRange(first, size).size())
                    .build();
        }
        return Response.status(404, "Unknown sucursal.")
                .header("Unknown sucursal.", 0)
                .build();

    }
    
}
