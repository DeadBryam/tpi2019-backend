/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.VentaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Kardex;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Venta;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 *
 * @author arevalo
 */
//@RunWith(value= PowerMockRunner.class)
public class FacturacionBeanTest{
//    
//    FacturacionBean fb;
//    Venta venta;
//    KardexFacade kf;
//    VentaFacade vf;
//    Venta ve;
//    @Mock
//    VentaFacade vfmock;
//    @Mock
//    KardexFacade kfmock;
//    @Mock
//    FacturacionBean fbmock;
//    @Mock
//    Venta vmock;
//    
//    @Before
//    public void init() throws Exception{
//        whenNew(KardexFacade.class).withNoArguments().thenReturn(kfmock);
//        whenNew(FacturacionBean.class).withNoArguments().thenReturn(fbmock);
//        kf= new KardexFacade();
//        vf = new VentaFacade();
//        fb= new FacturacionBean();
//    }
//    @Test
//    public void crearTest(){
//        ve= new Venta(1);
//        venta= mock(Venta.class);
//        EntityManager em = mock(EntityManager.class);
//        Whitebox.setInternalState(vf,"em",em);
//        when(vf.crear(venta).getIdVenta()).thenReturn(ve.getIdVenta());
//        
//           fb.crear();
// venta= new Venta();
//        ve.setFecha(Matchers.any(Date.class));
//        ve.setIdVenta(Matchers.any(Integer.class));
//        System.out.println("venta "+ve);
//        System.out.println("fb "+vf.crear(venta));
//        when(fb.ventaFacade.crear(ve)).thenReturn(venta);
//        ve=fb.ventaFacade.crear(ve);        
   // }
    
}
