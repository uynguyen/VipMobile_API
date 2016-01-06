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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 12125
 */
@Entity
@Table(catalog = "vipmobileshopapi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arguments.findAll", query = "SELECT a FROM Arguments a"),
    @NamedQuery(name = "Arguments.findById", query = "SELECT a FROM Arguments a WHERE a.id = :id"),
    @NamedQuery(name = "Arguments.findByName", query = "SELECT a FROM Arguments a WHERE a.name = :name"),
    @NamedQuery(name = "Arguments.findByDataType", query = "SELECT a FROM Arguments a WHERE a.dataType = :dataType"),
    @NamedQuery(name = "Arguments.findByDescription", query = "SELECT a FROM Arguments a WHERE a.description = :description"),
    @NamedQuery(name = "Arguments.findByValue", query = "SELECT a FROM Arguments a WHERE a.value = :value")})
public class Arguments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "data_type", length = 65535)
    private String dataType;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String value;

    public Arguments() {
    }

    public Arguments(Integer id) {
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        if (!(object instanceof Arguments)) {
            return false;
        }
        Arguments other = (Arguments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.Arguments[ id=" + id + " ]";
    }
    
}
