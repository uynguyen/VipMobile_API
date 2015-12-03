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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LeeSan
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByCode", query = "SELECT p FROM Product p WHERE p.code = :code"),
    @NamedQuery(name = "Product.findByImage", query = "SELECT p FROM Product p WHERE p.image = :image"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByAmount", query = "SELECT p FROM Product p WHERE p.amount = :amount"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByScreenSize", query = "SELECT p FROM Product p WHERE p.screenSize = :screenSize"),
    @NamedQuery(name = "Product.findByRam", query = "SELECT p FROM Product p WHERE p.ram = :ram"),
    @NamedQuery(name = "Product.findByCapacityPin", query = "SELECT p FROM Product p WHERE p.capacityPin = :capacityPin"),
    @NamedQuery(name = "Product.findBySimAmount", query = "SELECT p FROM Product p WHERE p.simAmount = :simAmount"),
    @NamedQuery(name = "Product.findByScreen", query = "SELECT p FROM Product p WHERE p.screen = :screen"),
    @NamedQuery(name = "Product.findByCpu", query = "SELECT p FROM Product p WHERE p.cpu = :cpu"),
    @NamedQuery(name = "Product.findByWeight", query = "SELECT p FROM Product p WHERE p.weight = :weight"),
    @NamedQuery(name = "Product.findByUsb", query = "SELECT p FROM Product p WHERE p.usb = :usb"),
    @NamedQuery(name = "Product.findByBluetooth", query = "SELECT p FROM Product p WHERE p.bluetooth = :bluetooth"),
    @NamedQuery(name = "Product.findByMainCamera", query = "SELECT p FROM Product p WHERE p.mainCamera = :mainCamera"),
    @NamedQuery(name = "Product.findByViceCamera", query = "SELECT p FROM Product p WHERE p.viceCamera = :viceCamera"),
    @NamedQuery(name = "Product.findByGpu", query = "SELECT p FROM Product p WHERE p.gpu = :gpu"),
    @NamedQuery(name = "Product.findByGuarantee", query = "SELECT p FROM Product p WHERE p.guarantee = :guarantee")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "code")
    private String code;
    @Size(max = 2147483647)
    @Column(name = "image")
    private String image;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "amount")
    private Integer amount;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Column(name = "screen_size")
    private Double screenSize;
    @Column(name = "ram")
    private Integer ram;
    @Column(name = "capacity_pin")
    private Integer capacityPin;
    @Column(name = "sim_amount")
    private Integer simAmount;
    @Size(max = 2147483647)
    @Column(name = "screen")
    private String screen;
    @Size(max = 2147483647)
    @Column(name = "cpu")
    private String cpu;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "usb")
    private Double usb;
    @Size(max = 2147483647)
    @Column(name = "bluetooth")
    private String bluetooth;
    @Column(name = "main_camera")
    private Double mainCamera;
    @Column(name = "vice_camera")
    private Double viceCamera;
    @Size(max = 2147483647)
    @Column(name = "gpu")
    private String gpu;
    @Column(name = "guarantee")
    private Integer guarantee;
    @JoinColumn(name = "id_producer", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private ProducerCategory idProducer;
    @OneToMany(mappedBy = "idProduct")
    @JsonBackReference
    private Collection<BillDetail> billDetailCollection;
    @OneToMany(mappedBy = "idProduct")
    @JsonBackReference
    private Collection<ProductColorDetail> productColorDetailCollection;

    public Product() {
    }

    public Product(Integer id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @XmlTransient
    public Collection<BillDetail> getBillDetailCollection() {
        return billDetailCollection;
    }

    public void setBillDetailCollection(Collection<BillDetail> billDetailCollection) {
        this.billDetailCollection = billDetailCollection;
    }

    @XmlTransient
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbo.POJO.Product[ id=" + id + " ]";
    }
    
}
