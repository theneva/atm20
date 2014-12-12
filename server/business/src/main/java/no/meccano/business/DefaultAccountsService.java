package no.meccano.business;

import no.meccano.domain.account.Account;
import no.meccano.domain.account.AccountNumberValidator;
import no.meccano.domain.account.PersonalDetails;
import no.meccano.domain.account.PersonalDetailsValidator;
import no.meccano.domain.account.payment.InsufficientBalanceException;
import no.meccano.domain.account.payment.NoSuchPaymentException;
import no.meccano.domain.account.payment.PendingPayment;
import no.meccano.domain.account.payment.PendingPaymentValidator;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;
import no.meccano.integration.AccountsRouter;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DefaultAccountsService implements AccountsService
{
    private AccountNumberValidator accountNumberValidator;
    private AccountsRouter accountsRouter;
    private PendingPaymentValidator pendingPaymentValidator;
    private PersonalDetailsValidator personalDetailsValidator;

    @Inject
    public DefaultAccountsService(final AccountNumberValidator accountNumberValidator, final AccountsRouter accountsRouter, final PendingPaymentValidator pendingPaymentValidator, final PersonalDetailsValidator personalDetailsValidator)
    {
        this.accountNumberValidator = accountNumberValidator;
        this.accountsRouter = accountsRouter;
        this.pendingPaymentValidator = pendingPaymentValidator;
        this.personalDetailsValidator = personalDetailsValidator;
    }

    @Override
    public Account findByAccountNumber(final String accountNumber) throws InvalidArgumentException, NullArgumentException
    {
        accountNumberValidator.validate(accountNumber);
        return accountsRouter.findByAccountNumber(accountNumber);
    }

    @Override
    public Account update(final Account account)
    {
        return accountsRouter.update(account);
    }

    @Override
    public PendingPayment cancelPaymentById(final Account account, final String paymentId) throws NoSuchPaymentException
    {
        final PendingPayment dummyPendingPayment = new PendingPayment();
        dummyPendingPayment.setId(paymentId);

        if (!account.getPendingPayments().contains(dummyPendingPayment))
        {
            throw new NoSuchPaymentException(paymentId);
        }

        return accountsRouter.cancelPayment(account, dummyPendingPayment);
    }

    @Override
    public PendingPayment createPendingPayment(final Account account, final PendingPayment pendingPayment) throws InvalidArgumentException, NullArgumentException, InsufficientBalanceException
    {
        pendingPaymentValidator.validate(pendingPayment);

        if (account.getBalance() < pendingPayment.getAmount()) {
            throw new InsufficientBalanceException(account.getBalance(), pendingPayment.getAmount());
        }

        return accountsRouter.createPendingPayment(account, pendingPayment);
    }

    @Override
    public Account updatePersonalDetails(final Account account, final PersonalDetails personalDetails) throws InvalidArgumentException, NullArgumentException
    {
        personalDetailsValidator.validate(personalDetails);
        account.setPersonalDetails(personalDetails);
        return accountsRouter.update(account);
    }
}
