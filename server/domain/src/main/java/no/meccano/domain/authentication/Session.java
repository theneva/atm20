package no.meccano.domain.authentication;

public class Session
{
    private String token;
    private String accountNumber;

    public Session()
    {
    }

    public Session(final String token, final String accountNumber)
    {
        this.token = token;
        this.accountNumber = accountNumber;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(final String token)
    {
        this.token = token;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(final String accountNumber)
    {
        this.accountNumber = accountNumber;
    }
}
