package no.meccano.business;

import no.meccano.data.SessionRepository;
import no.meccano.domain.account.Account;
import no.meccano.domain.account.AccountNumberValidator;
import no.meccano.domain.authentication.*;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.InvalidCredentialsException;
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

    @Inject
    private AccountService accountService;

    @Inject
    private TokenValidator tokenValidator;

    @Override
    public Session createSession(final AuthenticationAttempt authenticationAttempt) throws InvalidArgumentException, NullArgumentException, InvalidCredentialsException
    {
        authenticationAttemptValidator.validate(authenticationAttempt);

        final Account matchedAccount = accountService.findByAccountNumber(authenticationAttempt.getAccountNumber());

        if (matchedAccount == null) {
            throw new InvalidCredentialsException("No such account");
        }

        if (!authenticationAttempt.getPin().equals(matchedAccount.getPin()))
        {
            throw new InvalidCredentialsException("Invalid PIN");
        }

        return sessionRepository.createSession(matchedAccount);
    }

    @Override
    public Session findByToken(final String token) throws InvalidArgumentException, NullArgumentException, NoSuchSessionException
    {
        tokenValidator.validate(token);
        return sessionRepository.findByToken(token);
    }

    @Override
    public Session destroySessionByToken(final String token) throws InvalidArgumentException, NoSuchSessionException
    {
        tokenValidator.validate(token);
        return sessionRepository.destroyByToken(token);
    }
}
