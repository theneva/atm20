package no.meccano.data;

import no.meccano.domain.Session;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class MapSessionRepository implements SessionRepository
{
    final Map<String, Session> sessions = new HashMap<>();

    @Override
    public Session getByAccountNumber(final String accountNumber)
    {
        return sessions.get(accountNumber);
    }

    @Override
    public Session createSession(final String accountNumber)
    {
        final Session session = new Session(UUID.randomUUID().toString().toUpperCase(), accountNumber);
        sessions.put(accountNumber, session);
        return session;
    }
}
