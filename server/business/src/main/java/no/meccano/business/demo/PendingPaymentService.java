package no.meccano.business.demo;

import no.meccano.domain.account.payment.PendingPayment;

public interface PendingPaymentService
{
    PendingPayment getPendingPaymentById(final String id);
}
