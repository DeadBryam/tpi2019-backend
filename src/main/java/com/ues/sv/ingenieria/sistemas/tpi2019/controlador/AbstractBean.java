package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author bryan
 */
public abstract class AbstractBean<T> {

    List<T> listaDatos;

    protected abstract AbstractFacade<T> getFacade();

    public abstract T getEntity();

    public void crear() {
        if (getFacade() != null) {
            try {
                getFacade().create(getEntity());
                mensajeInfo("Transaccion exitosa");
                llenarLista();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                mensajeError("Ocurrio un error en la transaccion");
            }
        }
    }

    public void editar() {
        if (getFacade() != null) {
            try {
                getFacade().edit(getEntity());
                mensajeInfo("Transaccion exitosa");
                llenarLista();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                mensajeError("Ocurrio un error en la transaccion");
            }
        }
    }

    public void eliminar() {
        if (getFacade() != null) {
            try {
                getFacade().remove(getEntity());
                mensajeInfo("Transaccion exitosa");
                llenarLista();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                mensajeError("Ocurrio un error en la transaccion");
            }
        }
    }

    public void llenarLista() {
        if (getFacade().findAll() != null) {
            listaDatos = getFacade().findAll();
        } else {
            listaDatos = Collections.EMPTY_LIST;
        }
    }

    public List<T> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<T> listaDatos) {
        this.listaDatos = listaDatos;
    }

    public void mensajeInfo(String msg) {
        FacesMessages.info(msg);
    }

    public void mensajeError(String msg) {
        FacesMessages.error(msg);
    }

}
