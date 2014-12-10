package no.meccano.api;

import no.meccano.business.AccountsService;
import no.meccano.business.SessionsService;
import no.meccano.domain.account.Account;
import no.meccano.domain.account.PersonalDetails;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path(AccountsResource.PATH)
public class AccountsResource
{
    public static final String PATH = "/accounts";

    @Inject
    private SessionsService sessionsService;

    @Inject
    private AccountsService accountsService;

    @GET
    @Produces("application/json")
    public Response accounts()
    {
        return Response.ok("hello").build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateAccount(final PersonalDetails personalDetails, @HeaderParam("Authorization") final String token)
    {
        try
        {
            final Session session = sessionsService.findByToken(token);
            final Account updatedAccount = accountsService.updatePersonalDetails(session.getAccount(), personalDetails);
            return Response.ok()
                    .entity(updatedAccount)
                    .build();
        }
        catch (InvalidArgumentException | NullArgumentException e)
        {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(e.getMessage())).build();
        }
        catch (NoSuchSessionException e)
        {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ErrorResponse(e.getMessage())).build();
        }
    }
}
