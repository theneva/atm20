package no.meccano.domain.authentication;

import no.meccano.domain.account.AccountNumberValidator;
import no.meccano.domain.account.PinValidator;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DefaultAuthenticationAttemptValidator implements AuthenticationAttemptValidator
{
    @Inject
    private AccountNumberValidator accountNumberValidator;

    @Inject
    private PinValidator pinValidator;

    public void validate(final AuthenticationAttempt authenticationAttempt) throws NullArgumentException, InvalidArgumentException
    {
        if (authenticationAttempt == null)
        {
            throw new NullArgumentException("authenticationAttempt");
        }

        if (authenticationAttempt.getPin() == null)
        {
            throw new NullArgumentException("authenticationAttempt.pin");
        }

        pinValidator.validate(authenticationAttempt.getPin());

        accountNumberValidator.validate(authenticationAttempt.getAccountNumber());
    }
}
