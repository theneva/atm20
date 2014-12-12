package no.meccano.business;

import no.meccano.domain.account.Account;
import no.meccano.domain.authentication.*;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.InvalidCredentialsException;
import no.meccano.domain.common.NullArgumentException;
import no.meccano.integration.SessionsRouter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DefaultSessionsService implements SessionsService
{
    private static final int MAX_FAILED_PIN_ATTEMPTS = 3;

    private SessionsRouter sessionsRouter;
    private AuthenticationAttemptValidator authenticationAttemptValidator;
    private AccountsService accountsService;
    private TokenValidator tokenValidator;

    @Inject
    public DefaultSessionsService(final SessionsRouter sessionsRouter, final AuthenticationAttemptValidator authenticationAttemptValidator, final AccountsService accountsService, final TokenValidator tokenValidator)
    {
        this.sessionsRouter = sessionsRouter;
        this.authenticationAttemptValidator = authenticationAttemptValidator;
        this.accountsService = accountsService;
        this.tokenValidator = tokenValidator;
    }

    @Override
    public List<Session> findAll()
    {
        return sessionsRouter.findAll();
    }

    @Override
    public Session createSession(final AuthenticationAttempt authenticationAttempt) throws InvalidArgumentException, NullArgumentException, InvalidCredentialsException, TooManyFailedAttemptsException
    {
        authenticationAttemptValidator.validate(authenticationAttempt);

        final Account matchedAccount = accountsService.findByAccountNumber(authenticationAttempt.getAccountNumber());

        if (matchedAccount == null)
        {
            throw new InvalidCredentialsException("No such account");
        }

        if (!authenticationAttempt.getPin().equals(matchedAccount.getPin()))
        {
            if (matchedAccount.getFailedPinAttempts() <= MAX_FAILED_PIN_ATTEMPTS)
            {
                matchedAccount.setFailedPinAttempts(matchedAccount.getFailedPinAttempts() + 1);
            }

            accountsService.update(matchedAccount);

            if (matchedAccount.getFailedPinAttempts() > MAX_FAILED_PIN_ATTEMPTS)
            {
                throw new TooManyFailedAttemptsException();
            }

            throw new InvalidCredentialsException("Invalid PIN");
        }

        if (matchedAccount.getFailedPinAttempts() > 0) {
            matchedAccount.setFailedPinAttempts(0);
            accountsService.update(matchedAccount);
        }

        return sessionsRouter.createSession(matchedAccount);
    }

    @Override
    public Session findByToken(final String token) throws InvalidArgumentException, NullArgumentException, NoSuchSessionException
    {
        tokenValidator.validate(token);
        return sessionsRouter.findByToken(token);
    }

    @Override
    public Session destroySessionByToken(final String token) throws InvalidArgumentException, NoSuchSessionException, NullArgumentException
    {
        tokenValidator.validate(token);
        return sessionsRouter.destroyByToken(token);
    }
}
