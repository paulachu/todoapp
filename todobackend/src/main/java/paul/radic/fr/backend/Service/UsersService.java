package paul.radic.fr.backend.Service;

import paul.radic.fr.backend.Entity.Users;
import paul.radic.fr.backend.Repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UsersService {
    @Inject
    UserRepository userRepository;
    public Users getByUUID(String uuid)
    {
        return this.userRepository.findById(uuid);
    }
    public List<Users> getAll()
    {
        return userRepository.listAll();
    }
    public void addUser(Users user)
    {
        userRepository.persist(user);
    }
    public void deleteUser(String uuid)
    {
        userRepository.delete("uuid",uuid);
    }
    public boolean existUser(Users user)
    {
        return this.userRepository.findById(user.getUuid()) != null;
    }
}
