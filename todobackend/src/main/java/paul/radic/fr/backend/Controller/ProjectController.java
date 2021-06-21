package paul.radic.fr.backend.Controller;

import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;
import paul.radic.fr.backend.Entity.Project;
import paul.radic.fr.backend.Entity.Users;
import paul.radic.fr.backend.Service.ProjectService;
import paul.radic.fr.backend.Service.UsersService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.security.Principal;
import java.util.List;

@Path("/project")
@RolesAllowed({"user", "admin"})
public class ProjectController {
    @Inject
    ProjectService projectService;
    @Inject
    JsonWebToken token;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Project> getProjects()
    {
        String sub = token.claim("sub").get().toString();
        String username = token.claim("preferred_username").get().toString();
        var user = new Users(sub, username);
        return projectService.findProjects(user);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Project addProjects(Project project)
    {
        String sub = token.claim("sub").get().toString();
        String username = token.claim("preferred_username").get().toString();
        var user = new Users(sub, username);
        return projectService.addProject(project, user);
    }

}
