package no.meccano.domain.authentication;

import no.meccano.domain.common.InvalidArgumentException;

public interface TokenValidator
{
    public void validate(final String token) throws InvalidArgumentException;
}
