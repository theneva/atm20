package no.meccano.business;

import no.meccano.domain.account.Account;
import no.meccano.domain.account.PendingPayment;
import no.meccano.domain.account.payment.NoSuchPaymentException;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

public interface AccountService
{
    Account findByAccountNumber(final String accountNumber) throws InvalidArgumentException, NullArgumentException;

    PendingPayment cancelPaymentById(final Account account, final String paymentId) throws NoSuchPaymentException;
}
