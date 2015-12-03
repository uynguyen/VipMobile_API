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
@Table(name = "product_color_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductColorDetail.findAll", query = "SELECT p FROM ProductColorDetail p"),
    @NamedQuery(name = "ProductColorDetail.findById", query = "SELECT p FROM ProductColorDetail p WHERE p.id = :id")})
public class ProductColorDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_color", referencedColumnName = "id")
    @ManyToOne
    private ColorCategory idColor;
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    @ManyToOne
    private Product idProduct;

    public ProductColorDetail() {
    }

    public ProductColorDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ColorCategory getIdColor() {
        return idColor;
    }

    public void setIdColor(ColorCategory idColor) {
        this.idColor = idColor;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
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
        if (!(object instanceof ProductColorDetail)) {
            return false;
        }
        ProductColorDetail other = (ProductColorDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.ProductColorDetail[ id=" + id + " ]";
    }
    
}
