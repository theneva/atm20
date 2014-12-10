package no.meccano.domain.common;

public class InvalidArgumentException extends Exception
{
    public InvalidArgumentException(final String criteria)
    {
        super(criteria);
    }
}
