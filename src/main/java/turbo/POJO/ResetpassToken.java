/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.POJO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LeeSan
 */
@Entity
@Table(name = "resetpass_token", catalog = "vipmobileshopapi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResetpassToken.findAll", query = "SELECT r FROM ResetpassToken r"),
    @NamedQuery(name = "ResetpassToken.findById", query = "SELECT r FROM ResetpassToken r WHERE r.id = :id"),
    @NamedQuery(name = "ResetpassToken.findByAccessToken", query = "SELECT r FROM ResetpassToken r WHERE r.accessToken = :accessToken"),
    @NamedQuery(name = "ResetpassToken.findByExpire", query = "SELECT r FROM ResetpassToken r WHERE r.expire = :expire")})
public class ResetpassToken implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "access_token", length = 65535)
    private String accessToken;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expire;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private User idUser;

    public ResetpassToken() {
    }

    public ResetpassToken(Integer id) {
        this.id = id;
    }

    public ResetpassToken(Integer id, Date expire) {
        this.id = id;
        this.expire = expire;
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

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
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
        if (!(object instanceof ResetpassToken)) {
            return false;
        }
        ResetpassToken other = (ResetpassToken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.ResetpassToken[ id=" + id + " ]";
    }
    
}
