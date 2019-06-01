/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author arevalo
 */
@javax.ws.rs.ApplicationPath("wr")
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
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest.ArticuloRest.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest.BodegaRest.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest.CORSFilter.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest.FacturacionRest.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest.HistorialRest.class);
        resources.add(com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest.SucursalREST.class);
    }
    
}
