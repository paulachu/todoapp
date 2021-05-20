package paul.radic.fr.backend.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import paul.radic.fr.backend.Entity.Users;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<Users> {
}
