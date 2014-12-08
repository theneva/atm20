package no.meccano.domain.authentication;

import no.meccano.domain.account.Account;

public class Session
{
    private String token;
    private Account account;

    public Session()
    {
    }

    public Session(final String token, final Account account)
    {
        this.token = token;
        this.account = account;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(final String token)
    {
        this.token = token;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(final Account account)
    {
        this.account = account;
    }

    @Override
    public String toString()
    {
        return "Session{" +
                "token='" + token + '\'' +
                ", account=" + account +
                '}';
    }
}
