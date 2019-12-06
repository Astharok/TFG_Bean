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
@Table(name = "historiales_equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialesEquipos.findAll", query = "SELECT h FROM HistorialesEquipos h")
    , @NamedQuery(name = "HistorialesEquipos.findByIDHistorialEquipo", query = "SELECT h FROM HistorialesEquipos h WHERE h.iDHistorialEquipo = :iDHistorialEquipo")
    , @NamedQuery(name = "HistorialesEquipos.findByFechaInicio", query = "SELECT h FROM HistorialesEquipos h WHERE h.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "HistorialesEquipos.findByFechaFin", query = "SELECT h FROM HistorialesEquipos h WHERE h.fechaFin = :fechaFin")})
public class HistorialesEquipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Historial_Equipo")
    private Integer iDHistorialEquipo;
    @Column(name = "Fecha_Inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "Fecha Fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @JoinColumn(name = "ID_Equipo_FK", referencedColumnName = "ID_Equipo")
    @ManyToOne
    private Equipos iDEquipoFK;
    @JoinColumn(name = "ID_Usuario_FK", referencedColumnName = "ID_Usuario")
    @ManyToOne
    private Usuarios iDUsuarioFK;

    public HistorialesEquipos() {
    }

    public HistorialesEquipos(Integer iDHistorialEquipo) {
        this.iDHistorialEquipo = iDHistorialEquipo;
    }

    public Integer getIDHistorialEquipo() {
        return iDHistorialEquipo;
    }

    public void setIDHistorialEquipo(Integer iDHistorialEquipo) {
        this.iDHistorialEquipo = iDHistorialEquipo;
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

    public Equipos getIDEquipoFK() {
        return iDEquipoFK;
    }

    public void setIDEquipoFK(Equipos iDEquipoFK) {
        this.iDEquipoFK = iDEquipoFK;
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
        hash += (iDHistorialEquipo != null ? iDHistorialEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialesEquipos)) {
            return false;
        }
        HistorialesEquipos other = (HistorialesEquipos) object;
        if ((this.iDHistorialEquipo == null && other.iDHistorialEquipo != null) || (this.iDHistorialEquipo != null && !this.iDHistorialEquipo.equals(other.iDHistorialEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.HistorialesEquipos[ iDHistorialEquipo=" + iDHistorialEquipo + " ]";
    }
    
}
