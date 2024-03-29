package no.meccano.integration;

import no.meccano.domain.account.Account;
import no.meccano.domain.account.payment.PendingPayment;

public interface AccountsRouter
{
    Account findByAccountNumber(final String accountNumber);

    PendingPayment cancelPayment(final Account account, final PendingPayment pendingPayment);

    PendingPayment createPendingPayment(final Account account, final PendingPayment pendingPayment);

    Account update(Account account);
}
