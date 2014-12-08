package no.meccano.business;

import no.meccano.domain.authentication.AuthenticationAttempt;
import no.meccano.domain.authentication.Session;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

public interface SessionService
{
    Session createSession(final AuthenticationAttempt authenticationAttempt) throws InvalidArgumentException, NullArgumentException;

    Session findByAccountNumber(final String accountNumber) throws InvalidArgumentException, NullArgumentException;
}
