/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.seguridad;

import java.io.Serializable;

/**
 *
 * @author CarlosVJ
 */
public class Rol implements Serializable {

    private String id;
    private String descripcion;

    public Rol() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rol other = (Rol) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getId() + " - " + getDescripcion();
    }

    public String getId() {
        if (id == null) {
            id = "";
        }
        return id.trim();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        if (descripcion == null) {
            descripcion = "";
        }
        return descripcion.trim();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
