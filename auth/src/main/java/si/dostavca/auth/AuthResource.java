package si.dostavca.auth;

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

    private WebTarget target;
    private final String endpoint = "http://192.168.99.100:8081/v1/profile/";

    @GET
    @Path("health")
    public Response getHealth() {
        return Response.ok("{ \"status\" : \"OK\" }").build();
    }

    @POST
    @Path("login")
    public Response postLogin(User user) {
        target = ClientBuilder.newClient().target(endpoint + "packets-delivered");
        Response response = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON_TYPE));
        return response;
    }

}
