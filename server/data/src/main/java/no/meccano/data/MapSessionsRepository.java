package no.meccano.data;

import no.meccano.domain.account.Account;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.*;

@ApplicationScoped
public class MapSessionsRepository implements SessionsRepository
{
    @Inject
    private AccountsRepository accountsRepository;

    private final Map<String, Session> sessions = new HashMap<>();

    @Override
    public Session findByToken(final String token) throws NoSuchSessionException
    {
        // TODO: Remove this.
        insertDummyAndreasData();

        final Session retrievedSession = sessions.get(token);

        if (retrievedSession == null)
        {
            throw new NoSuchSessionException(token);
        }

        return retrievedSession;
    }

    private void insertDummyAndreasData()
    {
        final String andreasAccountNumber = "55555555555";
        final String andreasToken = "AD5C7873-60E7-4A47-BA40-380C900DFAF5";
        sessions.put(andreasToken, new Session(andreasToken, accountsRepository.findByAccountNumber(andreasAccountNumber)));
    }

    @Override
    public Session createSession(final Account account)
    {
        final String token = UUID.randomUUID().toString().toUpperCase();
        final Session session = new Session(token, account);
        sessions.put(token, session);
        return session;
    }

    public Session destroyByToken(final String token) throws NoSuchSessionException
    {
        final Session destroyedSession = sessions.remove(token);

        if (destroyedSession == null)
        {
            throw new NoSuchSessionException(token);
        }

        return destroyedSession;
    }

    @Override
    public List<Session> findAll()
    {
        insertDummyAndreasData();
        return new ArrayList<>(sessions.values());
    }
}
