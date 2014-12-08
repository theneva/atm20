package no.meccano.domain.authentication;

import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

public interface AuthenticationAttemptValidator
{
    void validate(final AuthenticationAttempt authenticationAttempt) throws NullArgumentException, InvalidArgumentException;
}
