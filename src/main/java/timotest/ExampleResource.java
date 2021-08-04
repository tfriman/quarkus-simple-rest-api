package timotest;

import org.eclipse.microprofile.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Random;

@Path("/hello")
public class ExampleResource {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleResource.class);

    private final Random random = new Random();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed(name = "helloEndpoint")
    public DomainObject hello() throws InterruptedException {
        LOG.info("/hello called");
        // make some variation to response time
        Thread.sleep(random.nextInt(200));
        return new DomainObject("hello");
    }

    private static class DomainObject {
        private final String message;
        private final LocalDateTime localDateTime;
        private final String hostname;

        public DomainObject(String hello) {
            this.message = hello;
            this.localDateTime = LocalDateTime.now();
            String hostnameTmp = "unknown";
            try {
                hostnameTmp = Inet4Address.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            this.hostname = hostnameTmp;
        }

        public String getMessage() {
            return message;
        }

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public String getHostname() {
            return hostname;
        }
    }
}