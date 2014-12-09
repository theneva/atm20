package no.meccano.domain.common;

public class InvalidCredentialsException extends Exception
{
    public InvalidCredentialsException(final String message)
    {
        super(message);
    }
}
