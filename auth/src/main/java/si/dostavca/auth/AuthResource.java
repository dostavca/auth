package si.dostavca.auth;

import com.kumuluz.ee.discovery.annotations.DiscoverService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("auth")
public class AuthResource {

    @Inject
    @DiscoverService(value = "dostavca-profile", version = "1.0.x", environment = "dev")
    private WebTarget target;

    @GET
    @Path("health")
    public Response getHealth() {
        return Response.ok("{ \"status\" : \"OK\" }").build();
    }

    @POST
    @Path("login")
    public Response postLogin(User user) {
        WebTarget service = target.path("v1/profile");

        Response response;

        try {
            response = service.request().post(Entity.json(user));
        } catch (ProcessingException e) {
            return Response.status(408).build();
        }

        return Response.fromResponse(response).build();
    }

}
