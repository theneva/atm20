package no.meccano.data;

import no.meccano.domain.account.Account;

public interface AccountRepository
{
    Account findByAccountNumber(final String accountNumber);
}
