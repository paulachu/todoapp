package paul.radic.fr.backend.Entity;

import javax.persistence.*;

@Entity
@Table
public class UserProject {
    @EmbeddedId
    private UserProjectId id;
    @ManyToOne
    @MapsId("uuid")
    private Users user;
    @ManyToOne
    @MapsId("project_id")
    private Project project;


    public UserProjectId getId() {
        return id;
    }

    public void setId(UserProjectId id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}