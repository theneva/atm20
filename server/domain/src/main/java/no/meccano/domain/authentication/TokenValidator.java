package no.meccano.domain.authentication;

import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

public interface TokenValidator
{
    public void validate(final String token) throws InvalidArgumentException, NullArgumentException;
}
