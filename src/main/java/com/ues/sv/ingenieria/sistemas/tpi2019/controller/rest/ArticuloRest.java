/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author lordbryan
 */
@Stateless
@Path("articulo")
public class ArticuloRest {

    @EJB
    ArticuloFacade articuloFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRange(
            @QueryParam("first") @DefaultValue("0") int first,
            @QueryParam("size") @DefaultValue("10") int size) {
        return Response.ok(articuloFacade.findRange(first, size))
                .header("Total-Reg", articuloFacade.count())
                .header("Page-Reg", articuloFacade.findRange(first, size).size())
                .header("Page-size", size)
                .build();
    }

    @GET
    @Path("/f")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findArticuloLike(
            @QueryParam("filter") @DefaultValue("") String filtro) {
        if (filtro == null || filtro.isEmpty()) {
            return Response.ok()
                    .header("Total-reg", 0)
                    .build();
        }

        return Response.ok(articuloFacade.findLike(filtro))
                .header("Total-Reg", articuloFacade.findLike(filtro).size())
                .build();
    }

}
