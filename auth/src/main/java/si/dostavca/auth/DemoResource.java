package si.dostavca.auth;

import com.kumuluz.ee.logs.cdi.Log;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Log
@Path("demo")
@RequestScoped
public class DemoResource {

    @GET
    @Path("info")
    public Response getDemo() {
        Demo demo = new Demo();
        return Response.ok().entity(demo).build();
    }

}
