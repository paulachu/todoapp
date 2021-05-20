package paul.radic.fr.backend.Entity;

import javax.persistence.*;

@Entity
@Table
public class Users {
    @Id
    @Column(name="uuid", nullable = false)
    private String uuid;
    @Column(nullable = false)
    private String username;
    public Users()
    {
    }
    public Users(String uuid, String username)
    {
        this.uuid = uuid;
        this.username = username;
    }
}