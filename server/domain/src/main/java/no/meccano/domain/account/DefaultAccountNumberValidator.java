package no.meccano.domain.account;

import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

import javax.ejb.Stateless;

@Stateless
public class DefaultAccountNumberValidator implements AccountNumberValidator
{
    public final static int DIGITS_IN_ACCOUNT_NUMBER = 11;

    @Override
    public void validate(final String accountNumber) throws NullArgumentException, InvalidArgumentException
    {
        if (accountNumber == null)
        {
            throw new NullArgumentException("accountNumber");
        }

        if (!accountNumber.matches("[0-9]{" + DIGITS_IN_ACCOUNT_NUMBER + "}"))
        {
            throw new InvalidArgumentException(accountNumber, "Account number must be consist of exactly " + DIGITS_IN_ACCOUNT_NUMBER + " digits");
        }
    }
}
