package no.meccano.domain.account;

import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

import javax.ejb.Stateless;

@Stateless
public class DefaultPersonalDetailsValidator implements PersonalDetailsValidator
{
    private static final int DIGITS_IN_POSTAL_CODE = 4;

    @Override
    public void validate(final PersonalDetails personalDetails) throws NullArgumentException, InvalidArgumentException
    {
        if (personalDetails == null) {
            throw new NullArgumentException("personalDetails");
        }

        if (personalDetails.getAddress() == null) {
            throw new NullArgumentException("personalDetails.address");
        }

        if (personalDetails.getAddress().trim().length() <= 0)
        {
            throw new InvalidArgumentException("Address must be at least 1 character and not only whitespace");
        }

        if (personalDetails.getFirstName() == null) {
            throw new NullArgumentException("personalDetails.firstName");
        }

        if (personalDetails.getFirstName().trim().length() <= 0)
        {
            throw new InvalidArgumentException("First name must be at least 1 character and not only whitespace");
        }

        if (personalDetails.getLastName() == null) {
            throw new NullArgumentException("personalDetails.lastName");
        }

        if (personalDetails.getLastName().trim().length() <= 0)
        {
            throw new InvalidArgumentException("Last name must be at least 1 character and not only whitespace");
        }

        if (personalDetails.getPostalCode() == null) {
            throw new NullArgumentException("personalDetails.postalCode");
        }

        if (!personalDetails.getPostalCode().matches("[0-9]{" + DIGITS_IN_POSTAL_CODE + "}"))
        {
            throw new InvalidArgumentException("Postal code must be exactly " + DIGITS_IN_POSTAL_CODE + " digits long");
        }

        if (personalDetails.getRegion() == null) {
            throw new NullArgumentException("personalDetails.region");
        }

        if (personalDetails.getRegion().trim().length() <= 0)
        {
            throw new InvalidArgumentException("Region must be at least 1 character and not only whitespace");
        }

        if (personalDetails.getState() == null) {
            throw new NullArgumentException("personalDetails.state");
        }

        if (personalDetails.getState().trim().length() <= 0)
        {
            throw new InvalidArgumentException("State must be at least 1 character and not only whitespace");
        }
    }
}
