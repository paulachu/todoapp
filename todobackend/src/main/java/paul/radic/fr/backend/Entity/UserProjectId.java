package paul.radic.fr.backend.Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserProjectId implements Serializable {
    public String uuid;
    public Long project_id;
}
