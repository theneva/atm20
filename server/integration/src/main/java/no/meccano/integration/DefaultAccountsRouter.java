package no.meccano.integration;

import no.meccano.data.AccountsRepository;
import no.meccano.domain.account.Account;
import no.meccano.domain.account.payment.PendingPayment;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DefaultAccountsRouter implements AccountsRouter
{
    private AccountsRepository accountsRepository;

    @Inject
    public DefaultAccountsRouter(final AccountsRepository accountsRepository)
    {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public Account findByAccountNumber(final String accountNumber)
    {
        return accountsRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public PendingPayment cancelPayment(final Account account, final PendingPayment pendingPayment)
    {
        return accountsRepository.cancelPendingPayment(account, pendingPayment);
    }

    @Override
    public PendingPayment createPendingPayment(final Account account, final PendingPayment pendingPayment)
    {
        return accountsRepository.createPendingPayment(account, pendingPayment);
    }

    @Override
    public Account update(final Account account)
    {
        return accountsRepository.update(account);
    }
}
