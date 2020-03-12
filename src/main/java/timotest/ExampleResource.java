package timotest;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed(name = "helloEndpoint")
    public DomainObject hello() {
        return new DomainObject("hello");
    }

    private class DomainObject {
        private final String message;

        public DomainObject(String hello) {
            this.message = hello;
        }

        public String getMessage() {
            return message;
        }
    }
}