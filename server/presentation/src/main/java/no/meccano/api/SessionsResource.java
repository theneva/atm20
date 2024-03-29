package no.meccano.api;

import no.meccano.business.AccountsService;
import no.meccano.business.SessionsService;
import no.meccano.domain.authentication.AuthenticationAttempt;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;
import no.meccano.domain.authentication.TooManyFailedAttemptsException;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.InvalidCredentialsException;
import no.meccano.domain.common.NullArgumentException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path(SessionsResource.PATH)
public class SessionsResource
{
    public static final String PATH = "/sessions";

    @Inject
    private AccountsService accountsService;

    @Inject
    private SessionsService sessionsService;

    @GET
    @Produces("application/json")
    public Response findAll()
    {
        return Response.ok(sessionsService.findAll()).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticate(final AuthenticationAttempt attempt)
    {
        try
        {
            final Session session = sessionsService.createSession(attempt);
            return Response.status(Response.Status.CREATED)
                    .entity(session.getAccount())
                    .header("Authorization", session.getToken())
                    .build();
        }
        catch (InvalidArgumentException | NullArgumentException e)
        {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse(e.getMessage()))
                    .build();
        }
        catch (InvalidCredentialsException e)
        {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(new ErrorResponse(e.getMessage()))
                    .build();
        }
        catch (TooManyFailedAttemptsException e)
        {
            return Response.status(423) // Locked
                    .entity(new ErrorResponse(e.getMessage()))
                    .build();
        }
    }

    @DELETE
    @Produces("application/json")
    public Response destroySession(@HeaderParam("Authorization") final String token)
    {
        try
        {
            sessionsService.destroySessionByToken(token);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        catch (NoSuchSessionException e)
        {
            return Response.status(420).build();
        }
        catch (InvalidArgumentException | NullArgumentException e)
        {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(e.getMessage())).build();
        }
    }
}
