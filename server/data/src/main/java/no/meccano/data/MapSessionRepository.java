package no.meccano.data;

import no.meccano.domain.account.Account;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.*;

@ApplicationScoped
public class MapSessionRepository implements SessionRepository
{
    @Inject
    private AccountRepository accountRepository;

    private final Map<String, Session> sessions = new HashMap<>();

    @Override
    public Session findByToken(final String token) throws NoSuchSessionException
    {
        final Session retrievedSession = sessions.get(token);

        if (retrievedSession == null)
        {
            throw new NoSuchSessionException(token);
        }

        return retrievedSession;
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
        return new ArrayList<>(sessions.values());
    }
}
