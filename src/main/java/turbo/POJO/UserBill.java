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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "user_bill", catalog = "vipmobileshopapi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBill.findAll", query = "SELECT u FROM UserBill u"),
    @NamedQuery(name = "UserBill.findById", query = "SELECT u FROM UserBill u WHERE u.id = :id"),
    @NamedQuery(name = "UserBill.findByCode", query = "SELECT u FROM UserBill u WHERE u.code = :code"),
    @NamedQuery(name = "UserBill.findByBookDate", query = "SELECT u FROM UserBill u WHERE u.bookDate = :bookDate"),
    @NamedQuery(name = "UserBill.findByTotal", query = "SELECT u FROM UserBill u WHERE u.total = :total"),
    @NamedQuery(name = "UserBill.findByVat", query = "SELECT u FROM UserBill u WHERE u.vat = :vat"),
    @NamedQuery(name = "UserBill.findBySale", query = "SELECT u FROM UserBill u WHERE u.sale = :sale"),
    @NamedQuery(name = "UserBill.findByAddress", query = "SELECT u FROM UserBill u WHERE u.address = :address"),
    @NamedQuery(name = "UserBill.findByPhone", query = "SELECT u FROM UserBill u WHERE u.phone = :phone"),
    @NamedQuery(name = "UserBill.findByStranportFee", query = "SELECT u FROM UserBill u WHERE u.stranportFee = :stranportFee")})
public class UserBill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double total;
    @Column(precision = 22)
    private Double vat;
    @Column(precision = 22)
    private Double sale;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String phone;
    @Column(name = "stranport_fee", precision = 22)
    private Double stranportFee;
    @OneToMany(mappedBy = "idBill")
    private Collection<BillDetail> billDetailCollection;
    @JoinColumn(name = "state", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private BillStateCode state;
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User idUser;

    public UserBill() {
    }

    public UserBill(Integer id) {
        this.id = id;
    }

    public UserBill(Integer id, Date bookDate) {
        this.id = id;
        this.bookDate = bookDate;
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

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getStranportFee() {
        return stranportFee;
    }

    public void setStranportFee(Double stranportFee) {
        this.stranportFee = stranportFee;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<BillDetail> getBillDetailCollection() {
        return billDetailCollection;
    }

    public void setBillDetailCollection(Collection<BillDetail> billDetailCollection) {
        this.billDetailCollection = billDetailCollection;
    }

    public BillStateCode getState() {
        return state;
    }

    public void setState(BillStateCode state) {
        this.state = state;
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
