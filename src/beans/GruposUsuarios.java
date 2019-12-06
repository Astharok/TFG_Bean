/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jose Raimundo Montes Lopez
 */
@Entity
@Table(name = "grupos_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GruposUsuarios.findAll", query = "SELECT g FROM GruposUsuarios g")
    , @NamedQuery(name = "GruposUsuarios.findByIDGrupoUsuarios", query = "SELECT g FROM GruposUsuarios g WHERE g.iDGrupoUsuarios = :iDGrupoUsuarios")
    , @NamedQuery(name = "GruposUsuarios.findByNombre", query = "SELECT g FROM GruposUsuarios g WHERE g.nombre = :nombre")})
public class GruposUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Grupo_Usuarios")
    private Integer iDGrupoUsuarios;
    @Column(name = "Nombre")
    private String nombre;
    @JoinColumn(name = "ID_Tarifa_FK", referencedColumnName = "ID_Tarifa")
    @ManyToOne
    private Tarifas iDTarifaFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDGrupoUsuarioFK")
    private Collection<GruposUsuariosAvisos> gruposUsuariosAvisosCollection;
    @OneToMany(mappedBy = "iDGrupoUsuarioFK")
    private Collection<Usuarios> usuariosCollection;

    public GruposUsuarios() {
    }

    public GruposUsuarios(Integer iDGrupoUsuarios) {
        this.iDGrupoUsuarios = iDGrupoUsuarios;
    }

    public Integer getIDGrupoUsuarios() {
        return iDGrupoUsuarios;
    }

    public void setIDGrupoUsuarios(Integer iDGrupoUsuarios) {
        this.iDGrupoUsuarios = iDGrupoUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tarifas getIDTarifaFK() {
        return iDTarifaFK;
    }

    public void setIDTarifaFK(Tarifas iDTarifaFK) {
        this.iDTarifaFK = iDTarifaFK;
    }

    @XmlTransient
    public Collection<GruposUsuariosAvisos> getGruposUsuariosAvisosCollection() {
        return gruposUsuariosAvisosCollection;
    }

    public void setGruposUsuariosAvisosCollection(Collection<GruposUsuariosAvisos> gruposUsuariosAvisosCollection) {
        this.gruposUsuariosAvisosCollection = gruposUsuariosAvisosCollection;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDGrupoUsuarios != null ? iDGrupoUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GruposUsuarios)) {
            return false;
        }
        GruposUsuarios other = (GruposUsuarios) object;
        if ((this.iDGrupoUsuarios == null && other.iDGrupoUsuarios != null) || (this.iDGrupoUsuarios != null && !this.iDGrupoUsuarios.equals(other.iDGrupoUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.GruposUsuarios[ iDGrupoUsuarios=" + iDGrupoUsuarios + " ]";
    }
    
}
