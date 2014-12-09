package no.meccano.data;

import no.meccano.domain.account.Account;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;

public interface SessionRepository
{
    Session findByToken(final String accountNumber);

    Session createSession(final Account account);

    Session destroyByToken(final String token) throws NoSuchSessionException;
}
