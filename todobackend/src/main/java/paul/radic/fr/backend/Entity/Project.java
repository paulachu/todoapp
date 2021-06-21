package paul.radic.fr.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table
public class Project extends PanacheEntity {
    private String name;
    private String description;
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "users_project", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "uuid", referencedColumnName = "uuid"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Users> users = new ArrayList<>();
    public Project()
    {
    }
    public Project(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public void addUser(Users user)
    {
        users.add(user);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
