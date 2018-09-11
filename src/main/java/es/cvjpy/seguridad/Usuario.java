/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.seguridad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    private String id;
    private String descripcion;
    private String password;
    private List<Rol> roles;

    public Usuario() {
    }

    private String encriptar(String dato) {
        String datoEncriptado = dato;
        return datoEncriptado;
    }

    private String desencriptar(String dato) {
        String datoDesencriptado = dato;
        return datoDesencriptado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
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
            id = "root";
        }
        return id.trim();
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Rol> getRoles() {
        if (roles == null) {
            roles = new ArrayList();
        }
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public boolean tiene(Rol este) {
        boolean ret = false;
        for (Rol mio : getRoles()) {
            if (mio.getId().trim().equals(este.getId().trim())) {
                ret = true;
                break;
            }
        }
        if (this.getId().trim().equals("root")) {
            ret = true;
        }
        return ret;
    }

    public boolean comprueba(char[] passwd) {
        boolean ret = false;
        String supas = new String(passwd);
        String mipas = this.getClave();
        if (supas.trim().equals(mipas.trim())) {
            ret = true;
        }
        return ret;
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

    public boolean sepermiten(List<Rol> roles) {
        boolean ret = false;
        for (Rol uno : roles) {
            if (tiene(uno)) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public void borra(Rol este) {
        List<Rol> nueva = new ArrayList();
        for (Rol uno : getRoles()) {
            if (!uno.getId().trim().equals(este.getId().trim())) {
                nueva.add(uno);
            }
        }
        setRoles(nueva);
    }

    public String getClave() {
        return desencriptar(getPassword());
    }

    public void setClave(String clave) {
        this.setPassword(encriptar(clave));
    }

    public String getPassword() {
        if (password == null) {
            password = "alfacvjpy";
        }
        return password.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
