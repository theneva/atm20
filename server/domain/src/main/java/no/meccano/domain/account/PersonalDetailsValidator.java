package no.meccano.domain.account;

import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

public interface PersonalDetailsValidator
{
    void validate(final PersonalDetails personalDetails) throws NullArgumentException, InvalidArgumentException;
}
