/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LeeSan
 */
@Entity
@Table(name = "product_detail", catalog = "turbo_mobileshop", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDetail.findAll", query = "SELECT p FROM ProductDetail p"),
    @NamedQuery(name = "ProductDetail.findById", query = "SELECT p FROM ProductDetail p WHERE p.id = :id"),
    @NamedQuery(name = "ProductDetail.findByScreenSize", query = "SELECT p FROM ProductDetail p WHERE p.screenSize = :screenSize"),
    @NamedQuery(name = "ProductDetail.findByRam", query = "SELECT p FROM ProductDetail p WHERE p.ram = :ram"),
    @NamedQuery(name = "ProductDetail.findByCapacityPin", query = "SELECT p FROM ProductDetail p WHERE p.capacityPin = :capacityPin"),
    @NamedQuery(name = "ProductDetail.findBySimAmount", query = "SELECT p FROM ProductDetail p WHERE p.simAmount = :simAmount"),
    @NamedQuery(name = "ProductDetail.findByScreen", query = "SELECT p FROM ProductDetail p WHERE p.screen = :screen"),
    @NamedQuery(name = "ProductDetail.findByCpu", query = "SELECT p FROM ProductDetail p WHERE p.cpu = :cpu"),
    @NamedQuery(name = "ProductDetail.findByWeight", query = "SELECT p FROM ProductDetail p WHERE p.weight = :weight"),
    @NamedQuery(name = "ProductDetail.findByUsb", query = "SELECT p FROM ProductDetail p WHERE p.usb = :usb"),
    @NamedQuery(name = "ProductDetail.findByBluetooth", query = "SELECT p FROM ProductDetail p WHERE p.bluetooth = :bluetooth"),
    @NamedQuery(name = "ProductDetail.findByMainCamera", query = "SELECT p FROM ProductDetail p WHERE p.mainCamera = :mainCamera"),
    @NamedQuery(name = "ProductDetail.findByViceCamera", query = "SELECT p FROM ProductDetail p WHERE p.viceCamera = :viceCamera"),
    @NamedQuery(name = "ProductDetail.findByGpu", query = "SELECT p FROM ProductDetail p WHERE p.gpu = :gpu"),
    @NamedQuery(name = "ProductDetail.findByGuarantee", query = "SELECT p FROM ProductDetail p WHERE p.guarantee = :guarantee")})
public class ProductDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "screen_size", precision = 17, scale = 17)
    private Double screenSize;
    private Integer ram;
    @Column(name = "capacity_pin")
    private Integer capacityPin;
    @Column(name = "sim_amount")
    private Integer simAmount;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String screen;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String cpu;
    @Column(precision = 17, scale = 17)
    private Double weight;
    @Column(precision = 17, scale = 17)
    private Double usb;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String bluetooth;
    @Column(name = "main_camera", precision = 17, scale = 17)
    private Double mainCamera;
    @Column(name = "vice_camera", precision = 17, scale = 17)
    private Double viceCamera;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String gpu;
    private Integer guarantee;
    @JoinColumn(name = "id_producer", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private ProducerCategory idProducer;
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Product idProduct;

    public ProductDetail() {
    }

    public ProductDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getCapacityPin() {
        return capacityPin;
    }

    public void setCapacityPin(Integer capacityPin) {
        this.capacityPin = capacityPin;
    }

    public Integer getSimAmount() {
        return simAmount;
    }

    public void setSimAmount(Integer simAmount) {
        this.simAmount = simAmount;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getUsb() {
        return usb;
    }

    public void setUsb(Double usb) {
        this.usb = usb;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Double getMainCamera() {
        return mainCamera;
    }

    public void setMainCamera(Double mainCamera) {
        this.mainCamera = mainCamera;
    }

    public Double getViceCamera() {
        return viceCamera;
    }

    public void setViceCamera(Double viceCamera) {
        this.viceCamera = viceCamera;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public Integer getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
    }

    public ProducerCategory getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(ProducerCategory idProducer) {
        this.idProducer = idProducer;
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
        if (!(object instanceof ProductDetail)) {
            return false;
        }
        ProductDetail other = (ProductDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.ProductDetail[ id=" + id + " ]";
    }
    
}
