package no.meccano.api;

import no.meccano.business.AccountService;
import no.meccano.business.SessionService;
import no.meccano.domain.account.Account;
import no.meccano.domain.authentication.AuthenticationAttempt;
import no.meccano.domain.authentication.Session;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

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
    private AccountService accountService;

    @Inject
    private SessionService sessionService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticate(final AuthenticationAttempt attempt)
    {
        try
        {
            final Account matchedAccount = accountService.findByAccountNumber(attempt.getAccountNumber());
            final Session session = sessionService.createSession(attempt);

            if (matchedAccount == null)
            {
                return Response.status(418).entity(new ErrorResponse("No such account")).build();
            }

            if (!attempt.getPin().equals(matchedAccount.getPin()))
            {
                return Response.status(401).entity(new ErrorResponse("Wrong pin")).build();
            }

            return Response.ok(matchedAccount).header("Authorization", session.getToken()).build();
        }
        catch (InvalidArgumentException | NullArgumentException e)
        {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(e.getMessage())).build();
        }
    }
}
