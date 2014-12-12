package no.meccano.business.demo;

import no.meccano.domain.account.payment.PendingPayment;
import no.meccano.integration.demo.PendingPaymentRouter;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RestDemoPendingPaymentService implements PendingPaymentService
{
    private PendingPaymentRouter pendingPaymentRouter;

    @Inject
    public RestDemoPendingPaymentService(final PendingPaymentRouter pendingPaymentRouter)
    {
        this.pendingPaymentRouter = pendingPaymentRouter;
    }

    @Override
    public PendingPayment getPendingPaymentById(final String id)
    {
        return pendingPaymentRouter.getPendingPaymentById(id);
    }
}
