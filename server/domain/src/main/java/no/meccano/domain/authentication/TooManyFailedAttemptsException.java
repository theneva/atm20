package no.meccano.domain.authentication;

public class TooManyFailedAttemptsException extends Exception
{
    public TooManyFailedAttemptsException()
    {
        super("Too many failed attempts");
    }
}
