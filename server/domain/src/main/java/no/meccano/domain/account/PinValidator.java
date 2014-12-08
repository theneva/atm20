package no.meccano.domain.account;

import no.meccano.domain.common.InvalidArgumentException;

public interface PinValidator
{
    void validate(final String pin) throws InvalidArgumentException;
}
