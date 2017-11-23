package si.dostavca.auth;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("auth")
@RequestScoped
public class AuthResource {

    @Inject
    @DiscoverService(value = "dostavca-profile", version = "1.0.x", environment = "dev")
    private WebTarget target;

    @POST
    @Path("login")
    @Metered
    public Response postLogin(User user) {
        WebTarget service = target.path("v1/profile/packets-delivered");

        Response response;

        try {
            response = service.request().post(Entity.json(user));
        } catch (ProcessingException e) {
            return Response.status(408).build();
        }

        return Response.fromResponse(response).build();
    }

}
