package es.cvjpy.seguridad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CarlosVJ
 */
public class MenuNodo implements Serializable {

    private String id;
    private List<Rol> roles;

    public MenuNodo() {
        this.id = "";
        this.roles = new ArrayList();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final MenuNodo other = (MenuNodo) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getId() + " - " + getRoles();
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

    public boolean isProtegido() {
        boolean ret = false;
        if (getRoles().size() > 0) {
            ret = true;
        }
        return ret;
    }

    public List<Rol> getRoles() {
        if (roles == null) {
            roles = new ArrayList();
        }
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }
}
