/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose Raimundo Montes Lopez
 */
@Entity
@Table(name = "grupos_usuarios_avisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GruposUsuariosAvisos.findAll", query = "SELECT g FROM GruposUsuariosAvisos g")
    , @NamedQuery(name = "GruposUsuariosAvisos.findByIDGrupoUsuariosAviso", query = "SELECT g FROM GruposUsuariosAvisos g WHERE g.iDGrupoUsuariosAviso = :iDGrupoUsuariosAviso")})
public class GruposUsuariosAvisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Grupo_Usuarios_Aviso")
    private Integer iDGrupoUsuariosAviso;
    @JoinColumn(name = "ID_Aviso_FK", referencedColumnName = "ID_Aviso")
    @ManyToOne(optional = false)
    private Avisos iDAvisoFK;
    @JoinColumn(name = "ID_Grupo_Usuario_FK", referencedColumnName = "ID_Grupo_Usuarios")
    @ManyToOne(optional = false)
    private GruposUsuarios iDGrupoUsuarioFK;

    public GruposUsuariosAvisos() {
    }

    public GruposUsuariosAvisos(Integer iDGrupoUsuariosAviso) {
        this.iDGrupoUsuariosAviso = iDGrupoUsuariosAviso;
    }

    public Integer getIDGrupoUsuariosAviso() {
        return iDGrupoUsuariosAviso;
    }

    public void setIDGrupoUsuariosAviso(Integer iDGrupoUsuariosAviso) {
        this.iDGrupoUsuariosAviso = iDGrupoUsuariosAviso;
    }

    public Avisos getIDAvisoFK() {
        return iDAvisoFK;
    }

    public void setIDAvisoFK(Avisos iDAvisoFK) {
        this.iDAvisoFK = iDAvisoFK;
    }

    public GruposUsuarios getIDGrupoUsuarioFK() {
        return iDGrupoUsuarioFK;
    }

    public void setIDGrupoUsuarioFK(GruposUsuarios iDGrupoUsuarioFK) {
        this.iDGrupoUsuarioFK = iDGrupoUsuarioFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDGrupoUsuariosAviso != null ? iDGrupoUsuariosAviso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GruposUsuariosAvisos)) {
            return false;
        }
        GruposUsuariosAvisos other = (GruposUsuariosAvisos) object;
        if ((this.iDGrupoUsuariosAviso == null && other.iDGrupoUsuariosAviso != null) || (this.iDGrupoUsuariosAviso != null && !this.iDGrupoUsuariosAviso.equals(other.iDGrupoUsuariosAviso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.GruposUsuariosAvisos[ iDGrupoUsuariosAviso=" + iDGrupoUsuariosAviso + " ]";
    }
    
}
