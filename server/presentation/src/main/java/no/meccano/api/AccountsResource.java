package no.meccano.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("accounts")
public class AccountsResource
{
    @GET
    @Produces("application/json")
    public Response accounts()
    {
        return Response.ok("hello").build();
    }
}
