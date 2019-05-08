/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.web;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author arevalo
 */
@javax.ws.rs.ApplicationPath("sistema")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.ArticuloFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.BodegaFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.CajaFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.CompraFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.DistribuidorFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.KardexFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.MarcaFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.MedidaFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.SucursalFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.TipoArticuloFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.TipoMedidaFacadeREST.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.web.VentaFacadeREST.class);
    }
    
}
