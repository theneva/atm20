package no.meccano.api;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path(AccountsResource.PATH)
public class AccountsResource
{
    public static final String PATH = "/accounts";

    @GET
    @Produces("application/json")
    public Response accounts()
    {
        return Response.ok("hello").build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateAccount(@HeaderParam("Authorization") final String token)
    {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
