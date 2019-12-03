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
@Table(name = "recargas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recargas.findAll", query = "SELECT r FROM Recargas r")
    , @NamedQuery(name = "Recargas.findByIDRecarga", query = "SELECT r FROM Recargas r WHERE r.iDRecarga = :iDRecarga")
    , @NamedQuery(name = "Recargas.findByFecha", query = "SELECT r FROM Recargas r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Recargas.findByCantidad", query = "SELECT r FROM Recargas r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "Recargas.findByNotas", query = "SELECT r FROM Recargas r WHERE r.notas = :notas")})
public class Recargas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Recarga")
    private Integer iDRecarga;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private double cantidad;
    @Column(name = "Notas")
    private String notas;
    @JoinColumn(name = "ID_Usuario_FK", referencedColumnName = "ID_Usuario")
    @ManyToOne
    private Usuarios iDUsuarioFK;

    public Recargas() {
    }

    public Recargas(Integer iDRecarga) {
        this.iDRecarga = iDRecarga;
    }

    public Recargas(Integer iDRecarga, double cantidad) {
        this.iDRecarga = iDRecarga;
        this.cantidad = cantidad;
    }

    public Integer getIDRecarga() {
        return iDRecarga;
    }

    public void setIDRecarga(Integer iDRecarga) {
        this.iDRecarga = iDRecarga;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
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
        hash += (iDRecarga != null ? iDRecarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recargas)) {
            return false;
        }
        Recargas other = (Recargas) object;
        if ((this.iDRecarga == null && other.iDRecarga != null) || (this.iDRecarga != null && !this.iDRecarga.equals(other.iDRecarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Recargas[ iDRecarga=" + iDRecarga + " ]";
    }
    
}
