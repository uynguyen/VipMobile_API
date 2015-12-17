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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author LeeSan
 */
@Entity
@Table(name = "user_bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBill.findAll", query = "SELECT u FROM UserBill u"),
    @NamedQuery(name = "UserBill.findById", query = "SELECT u FROM UserBill u WHERE u.id = :id"),
    @NamedQuery(name = "UserBill.findByCode", query = "SELECT u FROM UserBill u WHERE u.code = :code"),
    @NamedQuery(name = "UserBill.findByState", query = "SELECT u FROM UserBill u WHERE u.state = :state"),
    @NamedQuery(name = "UserBill.findByDate", query = "SELECT u FROM UserBill u WHERE u.date = :date"),
    @NamedQuery(name = "UserBill.findByTotal", query = "SELECT u FROM UserBill u WHERE u.total = :total")})
public class UserBill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "code")
    private String code;
    @Column(name = "state")
    private Boolean state;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @OneToMany(mappedBy = "idBill")
    @JsonBackReference
    private Collection<BillDetail> billDetailCollection;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private User idUser;

    public UserBill() {
    }

    public UserBill(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<BillDetail> getBillDetailCollection() {
        return billDetailCollection;
    }

    public void setBillDetailCollection(Collection<BillDetail> billDetailCollection) {
        this.billDetailCollection = billDetailCollection;
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
        if (!(object instanceof UserBill)) {
            return false;
        }
        UserBill other = (UserBill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.UserBill[ id=" + id + " ]";
    }

}
