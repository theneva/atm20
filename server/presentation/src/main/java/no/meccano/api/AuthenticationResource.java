package no.meccano.api;

import no.meccano.domain.AuthenticationAttempt;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("authenticate")
public class AuthenticationResource
{
    @POST
    @Consumes("application/json")
    public Response authenticate(final AuthenticationAttempt attempt) {
        return Response.ok("Authenticated?").build();
    }
}
