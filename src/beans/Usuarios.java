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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIDUsuario", query = "SELECT u FROM Usuarios u WHERE u.iDUsuario = :iDUsuario")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByApellido", query = "SELECT u FROM Usuarios u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuarios.findByApodo", query = "SELECT u FROM Usuarios u WHERE u.apodo = :apodo")
    , @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")
    , @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email")
    , @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuarios.findBySaldo", query = "SELECT u FROM Usuarios u WHERE u.saldo = :saldo")})
public class Usuarios implements Serializable {

    @OneToMany(mappedBy = "iDUsuarioFK")
    private Collection<Recargas> recargasCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Usuario")
    private Integer iDUsuario;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "Apodo")
    private String apodo;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "Saldo")
    private double saldo;
    @OneToMany(mappedBy = "iDUsuarioFK")
    private Collection<Sesiones> sesionesCollection;
    @OneToMany(mappedBy = "iDUsuarioFK")
    private Collection<HistorialesEquipos> historialesEquiposCollection;
    @OneToMany(mappedBy = "iDUsuarioFK")
    private Collection<Mensajes> mensajesCollection;
    @JoinColumn(name = "ID_Grupo_Usuario_FK", referencedColumnName = "ID_Grupo_Usuarios")
    @ManyToOne
    private GruposUsuarios iDGrupoUsuarioFK;

    public Usuarios() {
    }

    public Usuarios(Integer iDUsuario) {
        this.iDUsuario = iDUsuario;
    }

    public Usuarios(Integer iDUsuario, String apodo, String password, double saldo) {
        this.iDUsuario = iDUsuario;
        this.apodo = apodo;
        this.password = password;
        this.saldo = saldo;
    }

    public Integer getIDUsuario() {
        return iDUsuario;
    }

    public void setIDUsuario(Integer iDUsuario) {
        this.iDUsuario = iDUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @XmlTransient
    public Collection<Sesiones> getSesionesCollection() {
        return sesionesCollection;
    }

    public void setSesionesCollection(Collection<Sesiones> sesionesCollection) {
        this.sesionesCollection = sesionesCollection;
    }

    @XmlTransient
    public Collection<HistorialesEquipos> getHistorialesEquiposCollection() {
        return historialesEquiposCollection;
    }

    public void setHistorialesEquiposCollection(Collection<HistorialesEquipos> historialesEquiposCollection) {
        this.historialesEquiposCollection = historialesEquiposCollection;
    }

    @XmlTransient
    public Collection<Mensajes> getMensajesCollection() {
        return mensajesCollection;
    }

    public void setMensajesCollection(Collection<Mensajes> mensajesCollection) {
        this.mensajesCollection = mensajesCollection;
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
        hash += (iDUsuario != null ? iDUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.iDUsuario == null && other.iDUsuario != null) || (this.iDUsuario != null && !this.iDUsuario.equals(other.iDUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Usuarios[ iDUsuario=" + iDUsuario + " ]";
    }

    @XmlTransient
    public Collection<Recargas> getRecargasCollection() {
        return recargasCollection;
    }

    public void setRecargasCollection(Collection<Recargas> recargasCollection) {
        this.recargasCollection = recargasCollection;
    }
    
}
