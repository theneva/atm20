package no.meccano.domain.account.payment;

public class InsufficientBalanceException extends Exception
{
    public InsufficientBalanceException(final int balance, final int paymentAmount)
    {
        super("The current balance of '" + balance + "' is too low to authorize this payment of '" + paymentAmount + "'");
    }
}
