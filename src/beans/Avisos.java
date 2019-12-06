/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jose Raimundo Montes Lopez
 */
@Entity
@Table(name = "avisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avisos.findAll", query = "SELECT a FROM Avisos a")
    , @NamedQuery(name = "Avisos.findByIDAviso", query = "SELECT a FROM Avisos a WHERE a.iDAviso = :iDAviso")
    , @NamedQuery(name = "Avisos.findByTexto", query = "SELECT a FROM Avisos a WHERE a.texto = :texto")
    , @NamedQuery(name = "Avisos.findByFecha", query = "SELECT a FROM Avisos a WHERE a.fecha = :fecha")})
public class Avisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Aviso")
    private Integer iDAviso;
    @Column(name = "Texto")
    private String texto;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDAvisoFK")
    private Collection<GruposUsuariosAvisos> gruposUsuariosAvisosCollection;

    public Avisos() {
    }

    public Avisos(Integer iDAviso) {
        this.iDAviso = iDAviso;
    }

    public Integer getIDAviso() {
        return iDAviso;
    }

    public void setIDAviso(Integer iDAviso) {
        this.iDAviso = iDAviso;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<GruposUsuariosAvisos> getGruposUsuariosAvisosCollection() {
        return gruposUsuariosAvisosCollection;
    }

    public void setGruposUsuariosAvisosCollection(Collection<GruposUsuariosAvisos> gruposUsuariosAvisosCollection) {
        this.gruposUsuariosAvisosCollection = gruposUsuariosAvisosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAviso != null ? iDAviso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avisos)) {
            return false;
        }
        Avisos other = (Avisos) object;
        if ((this.iDAviso == null && other.iDAviso != null) || (this.iDAviso != null && !this.iDAviso.equals(other.iDAviso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Avisos[ iDAviso=" + iDAviso + " ]";
    }
    
}
