package no.meccano.api;

import no.meccano.business.AccountService;
import no.meccano.business.SessionService;
import no.meccano.domain.authentication.AuthenticationAttempt;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.InvalidCredentialsException;
import no.meccano.domain.common.NullArgumentException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path(SessionsResource.PATH)
public class SessionsResource
{
    public static final String PATH = "sessions";

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
            final Session session = sessionService.createSession(attempt);
            return Response.ok(session.getAccount()).header("Authorization", session.getToken()).build();
        }
        catch (InvalidArgumentException | NullArgumentException e)
        {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(e.getMessage())).build();
        }
        catch (InvalidCredentialsException e)
        {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ErrorResponse(e.getMessage())).build();
        }
    }

    @DELETE
    @Consumes("application/json")
    public Response destroySession(final String token)
    {
        try
        {
            sessionService.destroySessionByToken(token);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        catch (NoSuchSessionException e)
        {
            return Response.status(420).build();
        }
        catch (InvalidArgumentException e)
        {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(e.getMessage())).build();
        }
    }
}
