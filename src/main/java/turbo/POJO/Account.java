/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.POJO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author LeeSan
 */
@Entity
@Table(catalog = "turbo_mobileshop", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByFullName", query = "SELECT a FROM Account a WHERE a.fullName = :fullName"),
    @NamedQuery(name = "Account.findByAddress", query = "SELECT a FROM Account a WHERE a.address = :address"),
    @NamedQuery(name = "Account.findByBirthday", query = "SELECT a FROM Account a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "Account.findByGender", query = "SELECT a FROM Account a WHERE a.gender = :gender"),
    @NamedQuery(name = "Account.findByAvatar", query = "SELECT a FROM Account a WHERE a.avatar = :avatar"),
    @NamedQuery(name = "Account.findByVisaCode", query = "SELECT a FROM Account a WHERE a.visaCode = :visaCode")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "full_name", length = 2147483647)
    private String fullName;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String address;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private Boolean gender;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String avatar;
    @Size(max = 2147483647)
    @Column(name = "visa_code", length = 2147483647)
    private String visaCode;
    @OneToMany(mappedBy = "idAccount", fetch = FetchType.LAZY)
    @JsonBackReference
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Collection<User> userCollection;

    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getVisaCode() {
        return visaCode;
    }

    public void setVisaCode(String visaCode) {
        this.visaCode = visaCode;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.Account[ id=" + id + " ]";
    }

}
