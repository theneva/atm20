package no.meccano.domain.account;

import no.meccano.domain.account.payment.PendingPayment;

import java.util.ArrayList;
import java.util.List;

public class Account
{
    private PersonalDetails personalDetails;
    private String accountNumber;
    private int balance;
    private String pin;
    private int failedPinAttempts = 0;
    private List<PendingPayment> pendingPayments = new ArrayList<>();

    public Account(final PersonalDetails personalDetails, final String accountNumber, final int balance, final String pin, final List<PendingPayment> pendingPayments)
    {
        this.personalDetails = personalDetails;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
        this.pendingPayments = pendingPayments;
    }

    public PersonalDetails getPersonalDetails()
    {
        return personalDetails;
    }

    public void setPersonalDetails(final PersonalDetails personalDetails)
    {
        this.personalDetails = personalDetails;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(final String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(final int balance)
    {
        this.balance = balance;
    }

    public String getPin()
    {
        return pin;
    }

    public void setPin(final String pin)
    {
        this.pin = pin;
    }

    public int getFailedPinAttempts()
    {
        return failedPinAttempts;
    }

    public void setFailedPinAttempts(final int failedPinAttempts)
    {
        this.failedPinAttempts = failedPinAttempts;
    }

    public List<PendingPayment> getPendingPayments()
    {
        return pendingPayments;
    }

    public void setPendingPayments(final List<PendingPayment> pendingPayments)
    {
        this.pendingPayments = pendingPayments;
    }

    @Override
    public String toString()
    {
        return "Account{" +
                "personalDetails=" + personalDetails +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", pin='" + pin + '\'' +
                ", failedPinAttempts=" + failedPinAttempts +
                ", pendingPayments=" + pendingPayments +
                '}';
    }
}
