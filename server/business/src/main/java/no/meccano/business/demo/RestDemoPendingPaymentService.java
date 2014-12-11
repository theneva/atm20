package no.meccano.business.demo;

import no.meccano.domain.account.payment.PendingPayment;
import no.meccano.integration.demo.PendingPaymentRouter;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RestDemoPendingPaymentService implements PendingPaymentService
{
    @Inject
    private PendingPaymentRouter pendingPaymentRouter;

    @Override
    public PendingPayment getPendingPaymentById(final String id)
    {
        return pendingPaymentRouter.getPendingPaymentById(id);
    }
}
