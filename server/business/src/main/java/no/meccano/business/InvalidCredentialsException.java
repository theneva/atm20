package no.meccano.business;

public class InvalidCredentialsException extends Exception
{
    public InvalidCredentialsException(final String message)
    {
        super(message);
    }
}
