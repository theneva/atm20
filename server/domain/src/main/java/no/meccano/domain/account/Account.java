package no.meccano.domain.account;

import no.meccano.domain.account.payment.PendingPayment;

import java.util.ArrayList;
import java.util.List;

public class Account
{
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String postalCode;
    private String region;
    private String state;
    private String country;
    private String accountNumber;
    private int balance;
    private String pin;
    private int failedPinAttempts = 0;
    private List<PendingPayment> pendingPayments = new ArrayList<>();

    public Account(final String firstName, final String middleName, final String lastName, final String address, final String postalCode, final String region, final String state, final String country, final String accountNumber, final int balance, final String pin, final List<PendingPayment> pendingPayments)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.region = region;
        this.state = state;
        this.country = country;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
        this.pendingPayments = pendingPayments;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(final String middleName)
    {
        this.middleName = middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(final String address)
    {
        this.address = address;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(final String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(final String region)
    {
        this.region = region;
    }

    public String getState()
    {
        return state;
    }

    public void setState(final String state)
    {
        this.state = state;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(final String country)
    {
        this.country = country;
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
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", region='" + region + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", pin='" + pin + '\'' +
                ", failedPinAttempts=" + failedPinAttempts +
                ", pendingPayments=" + pendingPayments +
                '}';
    }
}
