package no.meccano.integration;

import no.meccano.domain.account.Account;
import no.meccano.domain.authentication.NoSuchSessionException;
import no.meccano.domain.authentication.Session;

import java.util.List;

public interface SessionsRouter
{
    Session findByToken(final String accountNumber) throws NoSuchSessionException;

    Session createSession(final Account account);

    Session destroyByToken(final String token) throws NoSuchSessionException;

    List<Session> findAll();
}
