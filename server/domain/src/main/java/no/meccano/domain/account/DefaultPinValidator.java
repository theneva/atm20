package no.meccano.domain.account;

import no.meccano.domain.common.InvalidArgumentException;

import javax.ejb.Stateless;

@Stateless
public class DefaultPinValidator implements PinValidator
{
    public static final int DIGITS_IN_PIN = 4;

    @Override
    public void validate(final String pin) throws InvalidArgumentException
    {
        if (!pin.matches("[0-9]{" + DIGITS_IN_PIN + "}"))
        {
            throw new InvalidArgumentException("The PIN code must be exactly " + DIGITS_IN_PIN + " digits");
        }
    }
}
