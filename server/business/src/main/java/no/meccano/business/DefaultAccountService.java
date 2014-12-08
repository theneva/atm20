package no.meccano.business;

import no.meccano.data.AccountRepository;
import no.meccano.domain.account.Account;
import no.meccano.domain.account.AccountNumberValidator;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DefaultAccountService implements AccountService
{
    @Inject
    private AccountNumberValidator accountNumberValidator;

    @Inject
    private AccountRepository accountRepository;

    @Override
    public Account findByAccountNumber(final String accountNumber) throws InvalidArgumentException, NullArgumentException
    {
        accountNumberValidator.validate(accountNumber);
        return accountRepository.findByAccountNumber(accountNumber);
    }
}
