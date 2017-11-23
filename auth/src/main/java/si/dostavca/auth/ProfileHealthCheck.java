package si.dostavca.auth;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
@Health
public class ProfileHealthCheck implements HealthCheck {

    private static final Logger log = Logger.getLogger(ProfileHealthCheck.class.getSimpleName());

    @Inject
    @DiscoverService(value = "dostavca-profile", version = "1.0.x", environment = "dev")
    private Optional<WebTarget> target;

    @Override
    public HealthCheckResponse call() {
        WebTarget service = null;

        if (target.isPresent()) {
            service = target.get().path("/health");
        } else {
            return HealthCheckResponse.named(ProfileHealthCheck.class.getSimpleName()).down().build();
        }

        Response response = null;

        try {
            response = service.request().get();
        } catch (ProcessingException e) {
            log.warning("Error processing request or response from dostavca-profile.");
        }

        if (response.getStatus() == 200) {
            return HealthCheckResponse.named(ProfileHealthCheck.class.getSimpleName()).up().build();
        }

        return HealthCheckResponse.named(ProfileHealthCheck.class.getSimpleName()).down().build();
    }

}
