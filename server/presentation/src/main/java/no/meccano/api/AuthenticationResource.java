package no.meccano.api;

import no.meccano.domain.Account;
import no.meccano.domain.AuthenticationAttempt;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("authenticate")
public class AuthenticationResource
{
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticate(final AuthenticationAttempt attempt) {

        if (!"1234".equals(attempt.getPin())) {
            return Response.status(418).entity(new ErrorResponse("No such account.")).build();
        }

        final Account matchedAccount = new Account(
                "Martin",
                null,
                "Lehmann",
                "Skogvollveien 36",
                "0580",
                "Oslo",
                "Oslo",
                "Norway",
                "147839473289",
                47589
        );

        return Response.ok(matchedAccount).build();
    }
}
