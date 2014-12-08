package no.meccano.domain.authentication;

import no.meccano.domain.account.AccountNumberValidator;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DefaultAuthenticationAttemptValidator implements AuthenticationAttemptValidator
{
    public static int DIGITS_IN_PIN = 4;

    @Inject
    private AccountNumberValidator accountNumberValidator;

    public void validate(final AuthenticationAttempt authenticationAttempt) throws NullArgumentException, InvalidArgumentException
    {
        if (authenticationAttempt == null)
        {
            throw new NullArgumentException("authenticationAttempt");
        }

        if (authenticationAttempt.getPin() == null) {
            throw new NullArgumentException("authenticationAttempt.pin");
        }

        if (!authenticationAttempt.getPin().matches("[0-9]{" + DIGITS_IN_PIN + "}")) {
            throw new InvalidArgumentException(authenticationAttempt.getPin(), "The PIN code must be exactly " + DIGITS_IN_PIN + " digits");
        }

        accountNumberValidator.validate(authenticationAttempt.getAccountNumber());
    }
}
