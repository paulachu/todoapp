package paul.radic.fr.backend.Service;

import paul.radic.fr.backend.Entity.Project;
import paul.radic.fr.backend.Entity.UserProject;
import paul.radic.fr.backend.Entity.Users;
import paul.radic.fr.backend.Repository.ProjectRepository;
import paul.radic.fr.backend.Repository.UserProjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class ProjectService
{
    @Inject
    ProjectRepository projectRepository;
    @Inject
    UserProjectRepository userProjectRepository;


    public void addProject(Project project)
    {
        projectRepository.persist(project);
    }
    public boolean deleteProject(long id)
    {
        return projectRepository.delete("id", id) != 0;
    }
    public List<Project> findProjects(String uuid)
    {
        return userProjectRepository.find("user_uuid", uuid).stream().map(UserProject::getProject).collect(Collectors.toList());
    }
    public List<Users> getUsers(Project project)
    {
        return userProjectRepository.find("project_id", project.id).stream().map(UserProject::getUser).collect(Collectors.toList());
    }
}
