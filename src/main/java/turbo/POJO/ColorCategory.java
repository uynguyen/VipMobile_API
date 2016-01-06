/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.POJO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author 12125
 */
@Entity
@Table(name = "color_category", catalog = "vipmobileshopapi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColorCategory.findAll", query = "SELECT c FROM ColorCategory c"),
    @NamedQuery(name = "ColorCategory.findById", query = "SELECT c FROM ColorCategory c WHERE c.id = :id"),
    @NamedQuery(name = "ColorCategory.findByValue", query = "SELECT c FROM ColorCategory c WHERE c.value = :value"),
    @NamedQuery(name = "ColorCategory.findByColorCode", query = "SELECT c FROM ColorCategory c WHERE c.colorCode = :colorCode")})
public class ColorCategory implements Serializable {
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
    @Column(name = "color_code", length = 65535)
    private String colorCode;
    @OneToMany(mappedBy = "idColor")
      @JsonBackReference
    @JsonIgnore
    private Collection<ProductColorDetail> productColorDetailCollection;

    public ColorCategory() {
    }

    public ColorCategory(Integer id) {
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

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProductColorDetail> getProductColorDetailCollection() {
        return productColorDetailCollection;
    }

    public void setProductColorDetailCollection(Collection<ProductColorDetail> productColorDetailCollection) {
        this.productColorDetailCollection = productColorDetailCollection;
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
        if (!(object instanceof ColorCategory)) {
            return false;
        }
        ColorCategory other = (ColorCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.ColorCategory[ id=" + id + " ]";
    }
    
}
