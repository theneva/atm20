package no.meccano.business;

import no.meccano.domain.account.Account;
import no.meccano.domain.account.PersonalDetails;
import no.meccano.domain.account.payment.PendingPayment;
import no.meccano.domain.account.payment.NoSuchPaymentException;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

public interface AccountsService
{
    Account findByAccountNumber(final String accountNumber) throws InvalidArgumentException, NullArgumentException;

    PendingPayment cancelPaymentById(final Account account, final String paymentId) throws NoSuchPaymentException;

    PendingPayment createPendingPayment(final Account account, final PendingPayment pendingPayment) throws InvalidArgumentException, NullArgumentException;

    Account updatePersonalDetails(final Account account, final PersonalDetails personalDetails) throws InvalidArgumentException, NullArgumentException;
}
