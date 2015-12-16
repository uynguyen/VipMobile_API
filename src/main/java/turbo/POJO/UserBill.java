package turbo.POJO;
// Generated Dec 16, 2015 11:33:51 AM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserBill generated by hbm2java
 */
@Entity
@Table(name = "user_bill", schema = "public"
)
@JsonAutoDetect
public class UserBill implements java.io.Serializable {

    private int id;
    private User user;
    private String code;
    private Boolean state;
    private Date date;
    private Double total;
    private Set<BillDetail> billDetails = new HashSet<BillDetail>(0);

    public UserBill() {
    }

    public UserBill(int id) {
        this.id = id;
    }

    public UserBill(int id, User user, String code, Boolean state, Date date, Double total, Set<BillDetail> billDetails) {
        this.id = id;
        this.user = user;
        this.code = code;
        this.state = state;
        this.date = date;
        this.total = total;
        this.billDetails = billDetails;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "code")
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "state")
    public Boolean getState() {
        return this.state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", length = 13)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "total", precision = 17, scale = 17)
    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userBill")
    public Set<BillDetail> getBillDetails() {
        return this.billDetails;
    }

    public void setBillDetails(Set<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

}
