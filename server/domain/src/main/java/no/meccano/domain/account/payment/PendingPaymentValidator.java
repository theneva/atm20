package no.meccano.domain.account.payment;

import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

public interface PendingPaymentValidator
{
    void validate(final PendingPayment pendingPayment) throws NullArgumentException, InvalidArgumentException;
}
