package no.meccano.domain.authentication;

import no.meccano.domain.common.InvalidArgumentException;

import javax.ejb.Stateless;
import java.util.UUID;

@Stateless
public class DefaultTokenValidator implements TokenValidator
{
    private static final int CHARACTERS_IN_TOKEN = UUID.randomUUID().toString().length();

    @Override
    public void validate(final String token) throws InvalidArgumentException
    {
        if (token.length() != CHARACTERS_IN_TOKEN)
        {
            throw new InvalidArgumentException(token, "Token should be exactly " + CHARACTERS_IN_TOKEN + " characters long");
        }
    }
}
