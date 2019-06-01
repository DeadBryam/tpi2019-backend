/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CajaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.VentaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Caja;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Venta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    @EJB
    VentaFacade ventafacade;
    @EJB
    KardexFacade kardexfacade;

    Venta venta;
    Venta idventa;
    Kardex kardex;
    List<Kardex> facturacionList = new ArrayList<>();

    @PathParam("idsucursal")
    String idSucursal;
    
    public final static String UNKNOWN = "Unknown sucursal.";

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
        return Response.status(404, UNKNOWN)
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
        return Response.status(404, UNKNOWN)
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
        return Response.status(400, UNKNOWN)
                .build();
    }

    @POST
    @Path("/{idcaja}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVenta(@PathParam("idcaja") int id,
            @QueryParam("estado") @DefaultValue("true") boolean estado,
            List<Kardex> itemList) {
        if (itemList != null && !itemList.isEmpty() && sucursalFacade.sucursalExists(idSucursal) && cajaFacade.cajaExist(id)) {
            venta = new Venta();
            venta.setEstadoVenta(estado);
            venta.setIdCaja(new Caja(id));
            venta.setFecha(new Date());
            venta.setIdSucursal(idSucursal);

            venta = ventafacade.crear(venta);
            for (Kardex item : itemList) {
                item.setIdVenta(venta);
                kardexfacade.create(item);
            }

            return Response.ok().build();
        } else if (sucursalFacade.sucursalExists(idSucursal) || cajaFacade.cajaExist(id)) {
            return Response.status(404, "coming soon.")
                    .build();
        }
        return Response.status(400, "Missing data.")
                .build();

    }

}
