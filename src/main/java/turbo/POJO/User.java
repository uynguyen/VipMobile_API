/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.POJO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author LeeSan
 */
@Entity
@Table(catalog = "vipmobileshopapi", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_account"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByIsActive", query = "SELECT u FROM User u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "User.findByCreateDate", query = "SELECT u FROM User u WHERE u.createDate = :createDate")})

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String username;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String email;
    @Column(name = "is_active")
    private Boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @OneToMany(mappedBy = "idUser")
    private Collection<ResetpassToken> resetpassTokenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<UserBill> userBillCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<AccessToken> accessTokenCollection;
    @OneToMany(mappedBy = "idUser")
    private Collection<RegisterToken> registerTokenCollection;
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    @ManyToOne
    private UserRole idRole;
    @JoinColumn(name = "id_account", referencedColumnName = "id")
    @OneToOne
    private Account idAccount;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ResetpassToken> getResetpassTokenCollection() {
        return resetpassTokenCollection;
    }

    public void setResetpassTokenCollection(Collection<ResetpassToken> resetpassTokenCollection) {
        this.resetpassTokenCollection = resetpassTokenCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<UserBill> getUserBillCollection() {
        return userBillCollection;
    }

    public void setUserBillCollection(Collection<UserBill> userBillCollection) {
        this.userBillCollection = userBillCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AccessToken> getAccessTokenCollection() {
        return accessTokenCollection;
    }

    public void setAccessTokenCollection(Collection<AccessToken> accessTokenCollection) {
        this.accessTokenCollection = accessTokenCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<RegisterToken> getRegisterTokenCollection() {
        return registerTokenCollection;
    }

    public void setRegisterTokenCollection(Collection<RegisterToken> registerTokenCollection) {
        this.registerTokenCollection = registerTokenCollection;
    }

    public UserRole getIdRole() {
        return idRole;
    }

    public void setIdRole(UserRole idRole) {
        this.idRole = idRole;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.User[ id=" + id + " ]";
    }
    
}
