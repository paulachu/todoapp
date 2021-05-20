package paul.radic.fr.backend.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import paul.radic.fr.backend.Entity.UserProject;
import paul.radic.fr.backend.Repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserProjectRepository implements PanacheRepository<UserProject> {
}
