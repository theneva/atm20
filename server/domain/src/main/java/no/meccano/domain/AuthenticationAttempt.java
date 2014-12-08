package no.meccano.domain;

public class AuthenticationAttempt
{
    public String pin;
    public String accountNumber;

    public String getPin()
    {
        return pin;
    }

    public void setPin(final String pin)
    {
        this.pin = pin;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(final String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString()
    {
        return "AuthenticationAttempt{" +
                "pin='" + pin + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
