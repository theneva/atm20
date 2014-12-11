package no.meccano.integration;

import no.meccano.data.SessionsRepository;
import no.meccano.domain.account.Account;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DefaultSessionsRouter implements SessionsRouter
{
    @Inject
    private SessionsRepository sessionsRepository;

    @Override
    public Session findByToken(final String accountNumber) throws NoSuchSessionException
    {
        return sessionsRepository.findByToken(accountNumber);
    }

    @Override
    public Session createSession(final Account account)
    {
        return sessionsRepository.createSession(account);
    }

    @Override
    public Session destroyByToken(final String token) throws NoSuchSessionException
    {
        return sessionsRepository.destroyByToken(token);
    }

    @Override
    public List<Session> findAll()
    {
        return sessionsRepository.findAll();
    }
}
