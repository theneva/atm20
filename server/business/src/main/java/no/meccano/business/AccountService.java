package no.meccano.business;

import no.meccano.domain.account.Account;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

public interface AccountService
{
    Account findByAccountNumber(final String accountNumber) throws InvalidArgumentException, NullArgumentException;
}
