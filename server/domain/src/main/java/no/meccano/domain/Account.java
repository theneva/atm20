package no.meccano.domain;

public class Account
{
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String zipCode;
    private String region;
    private String state;
    private String country;
    private String accountNumber;
    private int balance;

    public Account(final String firstName, final String middleName, final String lastName, final String address, final String zipCode, final String region, final String state, final String country, final String accountNumber, final int balance)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.region = region;
        this.state = state;
        this.country = country;
        this.accountNumber = accountNumber;
        this.balance = balance;
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

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(final String zipCode)
    {
        this.zipCode = zipCode;
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

    @Override
    public String toString()
    {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", region='" + region + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
