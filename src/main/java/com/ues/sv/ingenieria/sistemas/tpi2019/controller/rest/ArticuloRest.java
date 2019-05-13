/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
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
@Path("sucursal/{idsucursal}/articulo")
public class ArticuloRest {
    
    @EJB
    ArticuloFacade articuloFacade;
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
            return Response.ok(articuloFacade.findRange(first, size))
                    .header("Total-Reg", articuloFacade.count())
                    .header("Page-Reg", articuloFacade.findRange(first, size).size())
                    .build();
        }
        return Response.status(404, "Unknown sucursal.")
                .build();

    }
    
}
