package no.meccano.api;

import no.meccano.business.AccountsService;
import no.meccano.business.SessionsService;
import no.meccano.domain.account.Account;
import no.meccano.domain.account.payment.PendingPayment;
import no.meccano.domain.account.payment.NoSuchPaymentException;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path(PaymentsResource.PATH)
public class PaymentsResource
{
    public static final String PATH = "/payments";

    @Inject
    private AccountsService accountsService;

    @Inject
    private SessionsService sessionsService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAccount(final PendingPayment pendingPayment, @HeaderParam("Authorization") final String token)
    {
        try
        {
            final Account account = sessionsService.findByToken(token).getAccount();
            final PendingPayment createdPendingPayment = accountsService.createPendingPayment(account, pendingPayment);
            return Response.status(Response.Status.CREATED).entity(createdPendingPayment).build();
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

    @DELETE
    @Path("/{paymentId}")
    @Produces("application/json")
    public Response account(@PathParam("paymentId") final String paymentId, @HeaderParam("Authorization") final String token)
    {
        try
        {
            final Session session = sessionsService.findByToken(token);
            accountsService.cancelPaymentById(session.getAccount(), paymentId);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        catch (InvalidArgumentException | NullArgumentException e)
        {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(e.getMessage())).build();
        }
        catch (NoSuchSessionException e)
        {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ErrorResponse(e.getMessage())).build();
        }
        catch (NoSuchPaymentException e)
        {
            return Response.status(Response.Status.PRECONDITION_FAILED).entity(new ErrorResponse(e.getMessage())).build();
        }
    }
}
