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
@Table(name = "mensajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m")
    , @NamedQuery(name = "Mensajes.findByIDMensaje", query = "SELECT m FROM Mensajes m WHERE m.iDMensaje = :iDMensaje")
    , @NamedQuery(name = "Mensajes.findByTextoMensaje", query = "SELECT m FROM Mensajes m WHERE m.textoMensaje = :textoMensaje")
    , @NamedQuery(name = "Mensajes.findByFecha", query = "SELECT m FROM Mensajes m WHERE m.fecha = :fecha")})
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Mensaje")
    private Integer iDMensaje;
    @Column(name = "Texto_Mensaje")
    private String textoMensaje;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "ID_Conversacion_FK", referencedColumnName = "ID_Conversacion")
    @ManyToOne
    private Conversaciones iDConversacionFK;
    @JoinColumn(name = "ID_Usuario_FK", referencedColumnName = "ID_Usuario")
    @ManyToOne
    private Usuarios iDUsuarioFK;

    public Mensajes() {
    }

    public Mensajes(Integer iDMensaje) {
        this.iDMensaje = iDMensaje;
    }

    public Integer getIDMensaje() {
        return iDMensaje;
    }

    public void setIDMensaje(Integer iDMensaje) {
        this.iDMensaje = iDMensaje;
    }

    public String getTextoMensaje() {
        return textoMensaje;
    }

    public void setTextoMensaje(String textoMensaje) {
        this.textoMensaje = textoMensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Conversaciones getIDConversacionFK() {
        return iDConversacionFK;
    }

    public void setIDConversacionFK(Conversaciones iDConversacionFK) {
        this.iDConversacionFK = iDConversacionFK;
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
        hash += (iDMensaje != null ? iDMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.iDMensaje == null && other.iDMensaje != null) || (this.iDMensaje != null && !this.iDMensaje.equals(other.iDMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Mensajes[ iDMensaje=" + iDMensaje + " ]";
    }
    
}
