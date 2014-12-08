package no.meccano.domain.common;

public class InvalidArgumentException extends Exception
{
    public InvalidArgumentException(final Object argument, final String criteria)
    {
        super("Invalid argument '" + argument + "': " + criteria);
    }
}
