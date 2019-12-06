/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jose Raimundo Montes Lopez
 */
@Entity
@Table(name = "tarifas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifas.findAll", query = "SELECT t FROM Tarifas t")
    , @NamedQuery(name = "Tarifas.findByIDTarifa", query = "SELECT t FROM Tarifas t WHERE t.iDTarifa = :iDTarifa")
    , @NamedQuery(name = "Tarifas.findByNombre", query = "SELECT t FROM Tarifas t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tarifas.findByPrecioporhora", query = "SELECT t FROM Tarifas t WHERE t.precioporhora = :precioporhora")})
public class Tarifas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Tarifa")
    private Integer iDTarifa;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Precio_por_hora")
    private Long precioporhora;
    @OneToMany(mappedBy = "iDTarifaFK")
    private Collection<GruposUsuarios> gruposUsuariosCollection;

    public Tarifas() {
    }

    public Tarifas(Integer iDTarifa) {
        this.iDTarifa = iDTarifa;
    }

    public Integer getIDTarifa() {
        return iDTarifa;
    }

    public void setIDTarifa(Integer iDTarifa) {
        this.iDTarifa = iDTarifa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecioporhora() {
        return precioporhora;
    }

    public void setPrecioporhora(Long precioporhora) {
        this.precioporhora = precioporhora;
    }

    @XmlTransient
    public Collection<GruposUsuarios> getGruposUsuariosCollection() {
        return gruposUsuariosCollection;
    }

    public void setGruposUsuariosCollection(Collection<GruposUsuarios> gruposUsuariosCollection) {
        this.gruposUsuariosCollection = gruposUsuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDTarifa != null ? iDTarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifas)) {
            return false;
        }
        Tarifas other = (Tarifas) object;
        if ((this.iDTarifa == null && other.iDTarifa != null) || (this.iDTarifa != null && !this.iDTarifa.equals(other.iDTarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Tarifas[ iDTarifa=" + iDTarifa + " ]";
    }
    
}
