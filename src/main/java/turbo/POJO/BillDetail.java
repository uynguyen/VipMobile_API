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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LeeSan
 */
@Entity
@Table(name = "bill_detail", catalog = "turbo_mobileshop", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillDetail.findAll", query = "SELECT b FROM BillDetail b"),
    @NamedQuery(name = "BillDetail.findById", query = "SELECT b FROM BillDetail b WHERE b.id = :id"),
    @NamedQuery(name = "BillDetail.findByAmount", query = "SELECT b FROM BillDetail b WHERE b.amount = :amount"),
    @NamedQuery(name = "BillDetail.findByTotalPrice", query = "SELECT b FROM BillDetail b WHERE b.totalPrice = :totalPrice")})
public class BillDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer amount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price", precision = 17, scale = 17)
    private Double totalPrice;
    @JoinColumn(name = "id_select_color", referencedColumnName = "id")
    @ManyToOne
    private ColorCategory idSelectColor;
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    @ManyToOne
    private Product idProduct;
    @JoinColumn(name = "id_bill", referencedColumnName = "id")
    @ManyToOne
    private UserBill idBill;

  
    
    public BillDetail() {
    }

    public BillDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ColorCategory getIdSelectColor() {
        return idSelectColor;
    }

    public void setIdSelectColor(ColorCategory idSelectColor) {
        this.idSelectColor = idSelectColor;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public UserBill getIdBill() {
        return idBill;
    }

    public void setIdBill(UserBill idBill) {
        this.idBill = idBill;
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
        if (!(object instanceof BillDetail)) {
            return false;
        }
        BillDetail other = (BillDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.BillDetail[ id=" + id + " ]";
    }
    
}
