package no.meccano.api;

import no.meccano.data.AccountRepository;
import no.meccano.domain.Account;
import no.meccano.domain.AuthenticationAttempt;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("authenticate")
public class AuthenticationResource
{
    @Inject
    private AccountRepository accountRepository;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticate(final AuthenticationAttempt attempt)
    {
        final Account matchedAccount = accountRepository.findByAccountNumber(attempt.getAccountNumber());

        if (!attempt.getPin().equals(matchedAccount.getPin()))
        {
            return Response.status(401).entity(new ErrorResponse("Wrong pin.")).build();
        }

        return Response.ok(matchedAccount).build();
    }
}
