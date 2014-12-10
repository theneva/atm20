package no.meccano.domain;

import no.meccano.domain.account.PendingPayment;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

public interface PendingPaymentValidator
{
    void validate(final PendingPayment pendingPayment) throws NullArgumentException, InvalidArgumentException;
}
