package no.meccano.data;

import no.meccano.domain.authentication.Session;

public interface SessionRepository
{
    Session findByAccountNumber(final String accountNumber);
    Session createSession(final String accountNumber);
}
