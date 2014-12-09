package no.meccano.business;

import no.meccano.data.SessionsRepository;
import no.meccano.domain.account.Account;
import no.meccano.domain.account.AccountNumberValidator;
import no.meccano.domain.authentication.*;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.InvalidCredentialsException;
import no.meccano.domain.common.NullArgumentException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DefaultSessionsService implements SessionsService
{
    @Inject
    private SessionsRepository sessionsRepository;

    @Inject
    private AccountNumberValidator accountNumberValidator;

    @Inject
    private AuthenticationAttemptValidator authenticationAttemptValidator;

    @Inject
    private AccountService accountService;

    @Inject
    private TokenValidator tokenValidator;

    @Override
    public List<Session> findAll()
    {
        return sessionsRepository.findAll();
    }

    @Override
    public Session createSession(final AuthenticationAttempt authenticationAttempt) throws InvalidArgumentException, NullArgumentException, InvalidCredentialsException
    {
        authenticationAttemptValidator.validate(authenticationAttempt);

        final Account matchedAccount = accountService.findByAccountNumber(authenticationAttempt.getAccountNumber());

        if (matchedAccount == null)
        {
            throw new InvalidCredentialsException("No such account");
        }

        if (!authenticationAttempt.getPin().equals(matchedAccount.getPin()))
        {
            throw new InvalidCredentialsException("Invalid PIN");
        }

        return sessionsRepository.createSession(matchedAccount);
    }

    @Override
    public Session findByToken(final String token) throws InvalidArgumentException, NullArgumentException, NoSuchSessionException
    {
        tokenValidator.validate(token);
        return sessionsRepository.findByToken(token);
    }

    @Override
    public Session destroySessionByToken(final String token) throws InvalidArgumentException, NoSuchSessionException, NullArgumentException
    {
        tokenValidator.validate(token);
        return sessionsRepository.destroyByToken(token);
    }
}
