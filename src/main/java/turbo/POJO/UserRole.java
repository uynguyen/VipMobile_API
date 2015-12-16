package turbo.POJO;
// Generated Dec 16, 2015 11:33:51 AM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UserRole generated by hbm2java
 */
@Entity
@Table(name = "user_role", schema = "public"
)
@JsonAutoDetect
public class UserRole implements java.io.Serializable {

    private int id;
    private String role;
    private String description;
    private Set<User> users = new HashSet<User>(0);

    public UserRole() {
    }

    public UserRole(int id) {
        this.id = id;
    }

    public UserRole(int id, String role, String description, Set<User> users) {
        this.id = id;
        this.role = role;
        this.description = description;
        this.users = users;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "role")
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userRole")
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
