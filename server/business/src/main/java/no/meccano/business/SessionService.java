package no.meccano.business;

import no.meccano.domain.authentication.AuthenticationAttempt;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.InvalidCredentialsException;
import no.meccano.domain.common.NullArgumentException;

public interface SessionService
{
    Session createSession(final AuthenticationAttempt authenticationAttempt) throws InvalidArgumentException, NullArgumentException, InvalidCredentialsException;

    Session findByAccountNumber(final String accountNumber) throws InvalidArgumentException, NullArgumentException;

    Session destroySessionByToken(final String token) throws InvalidArgumentException, NoSuchSessionException;
}
