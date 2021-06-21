package paul.radic.fr.backend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.jboss.resteasy.spi.touri.MappedBy;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table
public class Users extends PanacheEntityBase {
    @Id
    @Column(name="uuid", nullable = false)
    private String uuid;
    @Column(nullable = false)
    private String username;

    @ManyToMany()
    @JoinTable(name = "users_project", joinColumns = @JoinColumn(name = "uuid", referencedColumnName = "uuid"),
            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Project> project = new ArrayList<>();
    public Users()
    {
    }
    public Users(String uuid, String username)
    {
        this.uuid = uuid;
        this.username = username;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonbTransient
    public List<Project> getProject() {
        return project;
    }
    public void setProject(List<Project> project) {
        this.project = project;
    }

    public String getUuid() {
        return uuid;
    }
    public String getUsername() {
        return username;
    }
}