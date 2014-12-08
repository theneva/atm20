package no.meccano.domain.common;

public class NullArgumentException extends Exception
{
    public NullArgumentException(final String argumentName)
    {
        super("Argument '" + argumentName + "' cannot be null");
    }
}
