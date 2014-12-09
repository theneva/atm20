package no.meccano.domain.authentication;

public class NoSuchSessionException extends Exception
{
    public NoSuchSessionException(final String token)
    {
        super("No session found with token: " + token);
    }
}
