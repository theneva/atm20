package no.meccano.api.setup;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("environment")
public class Environment
{
    @GET
    public String hello() {
        return "Hello world";
    }
}
