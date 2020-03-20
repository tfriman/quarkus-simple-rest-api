package timotest;

import org.eclipse.microprofile.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;

@Path("/hello")
public class ExampleResource {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed(name = "helloEndpoint")
    public DomainObject hello() {
        LOG.info("/hello called");
        return new DomainObject("hello");
    }

    private static class DomainObject {
        private final String message;

        public DomainObject(String hello) {
            this.message = hello;
        }

        public String getMessage() {
            return message;
        }
    }
}