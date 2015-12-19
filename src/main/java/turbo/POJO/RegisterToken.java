/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.POJO;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LeeSan
 */
@Entity
@Table(name = "register_token", catalog = "turbo_mobileshop", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegisterToken.findAll", query = "SELECT r FROM RegisterToken r"),
    @NamedQuery(name = "RegisterToken.findById", query = "SELECT r FROM RegisterToken r WHERE r.id = :id"),
    @NamedQuery(name = "RegisterToken.findByAccessToken", query = "SELECT r FROM RegisterToken r WHERE r.accessToken = :accessToken"),
    @NamedQuery(name = "RegisterToken.findByExpise", query = "SELECT r FROM RegisterToken r WHERE r.expise = :expise")})
public class RegisterToken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "access_token", length = 2147483647)
    private String accessToken;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expise;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    @com.fasterxml.jackson.annotation.JsonIgnore
    private User idUser;

    public RegisterToken() {
    }

    public RegisterToken(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getExpise() {
        return expise;
    }

    public void setExpise(Date expise) {
        this.expise = expise;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegisterToken)) {
            return false;
        }
        RegisterToken other = (RegisterToken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.RegisterToken[ id=" + id + " ]";
    }

}
