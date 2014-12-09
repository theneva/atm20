package no.meccano.business;

import no.meccano.data.SessionRepository;
import no.meccano.domain.account.Account;
import no.meccano.domain.account.AccountNumberValidator;
import no.meccano.domain.authentication.AuthenticationAttempt;
import no.meccano.domain.authentication.AuthenticationAttemptValidator;
import no.meccano.domain.authentication.Session;
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
    public Session findByAccountNumber(final String accountNumber) throws InvalidArgumentException, NullArgumentException
    {
        accountNumberValidator.validate(accountNumber);
        return sessionRepository.findByAccountNumber(accountNumber);
    }
}
