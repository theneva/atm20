package no.meccano.business;

import no.meccano.data.SessionRepository;
import no.meccano.domain.authentication.AuthenticationAttempt;
import no.meccano.domain.authentication.AuthenticationAttemptValidator;
import no.meccano.domain.authentication.Session;
import no.meccano.domain.account.AccountNumberValidator;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DefaultSessionService implements SessionService
{
    @Inject
    private SessionRepository sessionRepository;

    @Inject
    private AccountNumberValidator accountNumberValidator;

    @Inject
    private AuthenticationAttemptValidator authenticationAttemptValidator;

    @Override
    public Session createSession(final AuthenticationAttempt authenticationAttempt) throws InvalidArgumentException, NullArgumentException
    {
        authenticationAttemptValidator.validate(authenticationAttempt);
        return sessionRepository.createSession(authenticationAttempt.getAccountNumber());
    }

    @Override
    public Session findByAccountNumber(final String accountNumber) throws InvalidArgumentException, NullArgumentException
    {
        accountNumberValidator.validate(accountNumber);
        return sessionRepository.findByAccountNumber(accountNumber);
    }
}
