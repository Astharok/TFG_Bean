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
@Table(name = "conversaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversaciones.findAll", query = "SELECT c FROM Conversaciones c")
    , @NamedQuery(name = "Conversaciones.findByIDConversacion", query = "SELECT c FROM Conversaciones c WHERE c.iDConversacion = :iDConversacion")
    , @NamedQuery(name = "Conversaciones.findByFechaInicio", query = "SELECT c FROM Conversaciones c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Conversaciones.findByFechaFin", query = "SELECT c FROM Conversaciones c WHERE c.fechaFin = :fechaFin")})
public class Conversaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Conversacion")
    private Integer iDConversacion;
    @Column(name = "Fecha_Inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "Fecha_Fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(mappedBy = "iDConversacionFK")
    private Collection<Mensajes> mensajesCollection;

    public Conversaciones() {
    }

    public Conversaciones(Integer iDConversacion) {
        this.iDConversacion = iDConversacion;
    }

    public Integer getIDConversacion() {
        return iDConversacion;
    }

    public void setIDConversacion(Integer iDConversacion) {
        this.iDConversacion = iDConversacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public Collection<Mensajes> getMensajesCollection() {
        return mensajesCollection;
    }

    public void setMensajesCollection(Collection<Mensajes> mensajesCollection) {
        this.mensajesCollection = mensajesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDConversacion != null ? iDConversacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversaciones)) {
            return false;
        }
        Conversaciones other = (Conversaciones) object;
        if ((this.iDConversacion == null && other.iDConversacion != null) || (this.iDConversacion != null && !this.iDConversacion.equals(other.iDConversacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Conversaciones[ iDConversacion=" + iDConversacion + " ]";
    }
    
}
