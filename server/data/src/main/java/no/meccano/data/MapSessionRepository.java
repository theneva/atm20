package no.meccano.data;

import no.meccano.domain.account.Account;
import no.meccano.domain.authentication.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class MapSessionRepository implements SessionRepository
{
    @Inject
    private AccountRepository accountRepository;

    private final Map<String, Session> sessions = new HashMap<>();

    @Override
    public Session findByAccountNumber(final String accountNumber)
    {
        return sessions.get(accountNumber);
    }

    @Override
    public Session createSession(final Account account)
    {
        final String token = UUID.randomUUID().toString().toUpperCase();
        final Session session = new Session(token, account);
        sessions.put(account.getAccountNumber(), session);
        return session;
    }
}
