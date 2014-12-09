package no.meccano.business;

import no.meccano.domain.authentication.AuthenticationAttempt;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.InvalidCredentialsException;
import no.meccano.domain.common.NullArgumentException;

import java.util.List;

public interface SessionService
{
    List<Session> findAll();

    Session createSession(final AuthenticationAttempt authenticationAttempt) throws InvalidArgumentException, NullArgumentException, InvalidCredentialsException;

    Session findByToken(final String accountNumber) throws InvalidArgumentException, NullArgumentException, NoSuchSessionException;

    Session destroySessionByToken(final String token) throws InvalidArgumentException, NoSuchSessionException, NullArgumentException;
}
