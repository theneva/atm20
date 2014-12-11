package no.meccano.integration.demo;

import no.meccano.domain.account.payment.PendingPayment;

public interface PendingPaymentRouter
{
    PendingPayment getPendingPaymentById(final String id);
}
