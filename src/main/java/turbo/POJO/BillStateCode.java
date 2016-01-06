/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.POJO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 12125
 */
@Entity
@Table(name = "bill_state_code", catalog = "vipmobileshopapi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillStateCode.findAll", query = "SELECT b FROM BillStateCode b"),
    @NamedQuery(name = "BillStateCode.findById", query = "SELECT b FROM BillStateCode b WHERE b.id = :id"),
    @NamedQuery(name = "BillStateCode.findByValue", query = "SELECT b FROM BillStateCode b WHERE b.value = :value"),
    @NamedQuery(name = "BillStateCode.findByDescription", query = "SELECT b FROM BillStateCode b WHERE b.description = :description")})
public class BillStateCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String value;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String description;
    @OneToOne(mappedBy = "state")
    private UserBill userBill;

    public BillStateCode() {
    }

    public BillStateCode(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserBill getUserBill() {
        return userBill;
    }

    public void setUserBill(UserBill userBill) {
        this.userBill = userBill;
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
        if (!(object instanceof BillStateCode)) {
            return false;
        }
        BillStateCode other = (BillStateCode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.BillStateCode[ id=" + id + " ]";
    }
    
}
