/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose Raimundo Montes Lopez
 */
@Entity
@Table(name = "sesiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesiones.findAll", query = "SELECT s FROM Sesiones s")
    , @NamedQuery(name = "Sesiones.findByIDSesion", query = "SELECT s FROM Sesiones s WHERE s.iDSesion = :iDSesion")
    , @NamedQuery(name = "Sesiones.findBySesionInicio", query = "SELECT s FROM Sesiones s WHERE s.sesionInicio = :sesionInicio")})
public class Sesiones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Sesion")
    private Integer iDSesion;
    @Column(name = "Sesion_Inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sesionInicio;
    @JoinColumn(name = "ID_Usuario_FK", referencedColumnName = "ID_Usuario")
    @ManyToOne
    private Usuarios iDUsuarioFK;

    public Sesiones() {
    }

    public Sesiones(Integer iDSesion) {
        this.iDSesion = iDSesion;
    }

    public Integer getIDSesion() {
        return iDSesion;
    }

    public void setIDSesion(Integer iDSesion) {
        this.iDSesion = iDSesion;
    }

    public Date getSesionInicio() {
        return sesionInicio;
    }

    public void setSesionInicio(Date sesionInicio) {
        this.sesionInicio = sesionInicio;
    }

    public Usuarios getIDUsuarioFK() {
        return iDUsuarioFK;
    }

    public void setIDUsuarioFK(Usuarios iDUsuarioFK) {
        this.iDUsuarioFK = iDUsuarioFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDSesion != null ? iDSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesiones)) {
            return false;
        }
        Sesiones other = (Sesiones) object;
        if ((this.iDSesion == null && other.iDSesion != null) || (this.iDSesion != null && !this.iDSesion.equals(other.iDSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Sesiones[ iDSesion=" + iDSesion + " ]";
    }
    
}
