package paul.radic.fr.backend.Service;

import paul.radic.fr.backend.Entity.Project;
import paul.radic.fr.backend.Entity.Users;
import paul.radic.fr.backend.Repository.ProjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.LockModeType;
import java.util.List;


@ApplicationScoped
public class ProjectService
{
    @Inject
    ProjectRepository projectRepository;
    @Inject
    UsersService usersService;

    public Project addProject(Project project, Users user)
    {
        if (!usersService.existUser(user))
        {
            usersService.addUser(user);
        }
        var userDB = usersService.getByUUID(user.getUuid());
        project.addUser(userDB);
        try {
            this.projectRepository.persist(project);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return project;
    }
    public boolean deleteProject(long id)
    {
        return projectRepository.delete("id", id) != 0;
    }
    public List<Project> findProjects(Users user)
    {
        if (!usersService.existUser(user))
        {
            usersService.addUser(user);
        }
        var userDB = usersService.getByUUID(user.getUuid());
        return userDB.getProject();
    }
    public List<Users> getUsers(Project project)
    {
        return null;
    }

}
