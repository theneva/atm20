package no.meccano.data;

import no.meccano.domain.account.Account;
import no.meccano.domain.account.payment.PendingPayment;

public interface AccountsRepository
{
    Account findByAccountNumber(final String accountNumber);

    PendingPayment cancelPendingPayment(final Account account, final PendingPayment pendingPayment);

    PendingPayment createPendingPayment(final Account account, final PendingPayment pendingPayment);

    Account update(Account account);
}
