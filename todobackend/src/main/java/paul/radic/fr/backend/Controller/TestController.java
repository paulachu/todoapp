package paul.radic.fr.backend.Controller;

import paul.radic.fr.backend.Service.ProjectService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestController
{
    @Inject
    ProjectService projectService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public String hello()
    {
        return "{\"content\":\"Hello\"}";
    }

}
