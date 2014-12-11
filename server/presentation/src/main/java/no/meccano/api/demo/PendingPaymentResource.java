package no.meccano.api.demo;

import no.meccano.business.demo.PendingPaymentService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path(PendingPaymentResource.PATH)
public class PendingPaymentResource
{
    public static final String PATH = "/pending-payments";

    @Inject
    private PendingPaymentService pendingPaymentService;

    @GET
    public Response getAPendingPayment() {
        return Response.ok(pendingPaymentService.getPendingPaymentById("3E0E6762-C942-48FD-9E97-7184DABEB29D"))
                .build();
    }
}
