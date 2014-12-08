package no.meccano.api;

import no.meccano.data.AccountRepository;
import no.meccano.data.SessionRepository;
import no.meccano.domain.Account;
import no.meccano.domain.AuthenticationAttempt;
import no.meccano.domain.Session;

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

    @Inject
    private SessionRepository sessionRepository;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticate(final AuthenticationAttempt attempt)
    {
        final Account matchedAccount = accountRepository.findByAccountNumber(attempt.getAccountNumber());

        if (matchedAccount == null) {
            return Response.status(418).entity(new ErrorResponse("No such account")).build();
        }

        if (!attempt.getPin().equals(matchedAccount.getPin()))
        {
            return Response.status(401).entity(new ErrorResponse("Wrong pin")).build();
        }

        final Session session = sessionRepository.createSession(matchedAccount.getAccountNumber());

        return Response.ok(matchedAccount).header("Authorization", session.getToken()).build();
    }
}
