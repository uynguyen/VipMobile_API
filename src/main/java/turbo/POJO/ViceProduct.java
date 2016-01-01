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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LeeSan
 */
@Entity
@Table(name = "vice_product", catalog = "turbo_mobileshop", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViceProduct.findAll", query = "SELECT v FROM ViceProduct v"),
    @NamedQuery(name = "ViceProduct.findById", query = "SELECT v FROM ViceProduct v WHERE v.id = :id"),
    @NamedQuery(name = "ViceProduct.findByName", query = "SELECT v FROM ViceProduct v WHERE v.name = :name"),
    @NamedQuery(name = "ViceProduct.findByValue", query = "SELECT v FROM ViceProduct v WHERE v.value = :value"),
    @NamedQuery(name = "ViceProduct.findByImage", query = "SELECT v FROM ViceProduct v WHERE v.image = :image"),
    @NamedQuery(name = "ViceProduct.findByCondition", query = "SELECT v FROM ViceProduct v WHERE v.condition = :condition")})
public class ViceProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double value;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String image;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String condition;

    public ViceProduct() {
    }

    public ViceProduct(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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
        if (!(object instanceof ViceProduct)) {
            return false;
        }
        ViceProduct other = (ViceProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.ViceProduct[ id=" + id + " ]";
    }
    
}
