package timotest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Provides different paths under same root for route testing purposes.
 */
@Path("/api")
public class ApiResource {

    @GET
    public String basePath() {
        return "/api";
    }
    @GET
    @Path("public")
    public String publicPath() {
        return "/api/public";
    }

    @GET
    @Path("public/{ext}")
    public String publicPath(@PathParam("ext") String ext) {
        return "/api/public/" + ext;
    }

    @GET
    @Path("private")
    public String privatePath() {
        return "/api/private";
    }

    @GET
    @Path("private/{ext}")
    public String privatePathExtended(@PathParam("ext") String ext) {
        return "/api/private/"+ext;
    }

}
