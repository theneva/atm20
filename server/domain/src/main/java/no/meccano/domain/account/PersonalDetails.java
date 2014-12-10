package no.meccano.domain.account;

public class PersonalDetails
{
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String region;
    private String state;

    public PersonalDetails()
    {
    }

    public PersonalDetails(final String firstName, final String lastName, final String address, final String postalCode, final String region, final String state)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.region = region;
        this.state = state;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
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

    @Override
    public String toString()
    {
        return "PersonalDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", region='" + region + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
