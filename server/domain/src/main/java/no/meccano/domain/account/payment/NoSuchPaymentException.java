package no.meccano.domain.account.payment;

public class NoSuchPaymentException extends Exception
{
    public NoSuchPaymentException(final String paymentId)
    {
        super("No payment with id '" + paymentId + "' available.");
    }
}
