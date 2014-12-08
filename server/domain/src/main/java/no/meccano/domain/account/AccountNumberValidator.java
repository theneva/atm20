package no.meccano.domain.account;

import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

public interface AccountNumberValidator
{
    void validate(final String accountNumber) throws NullArgumentException, InvalidArgumentException;
}
