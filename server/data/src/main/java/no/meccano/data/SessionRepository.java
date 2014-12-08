package no.meccano.data;

import no.meccano.domain.Session;

public interface SessionRepository
{
    Session getByAccountNumber(final String accountNumber);
    Session createSession(final String accountNumber);
}
