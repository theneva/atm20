package no.meccano.data;

import no.meccano.domain.Account;

public interface AccountRepository
{
    Account findByAccountNumber(final String accountNumber);
}
