package no.meccano.business;

import no.meccano.data.AccountRepository;
import no.meccano.domain.account.Account;
import no.meccano.domain.account.AccountNumberValidator;
import no.meccano.domain.account.PersonalDetails;
import no.meccano.domain.account.PersonalDetailsValidator;
import no.meccano.domain.account.payment.NoSuchPaymentException;
import no.meccano.domain.account.payment.PendingPayment;
import no.meccano.domain.account.payment.PendingPaymentValidator;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DefaultAccountsService implements AccountsService
{
    @Inject
    private AccountNumberValidator accountNumberValidator;

    @Inject
    private AccountRepository accountsRepository;

    @Inject
    private PendingPaymentValidator pendingPaymentValidator;

    @Inject
    private PersonalDetailsValidator personalDetailsValidator;

    @Override
    public Account findByAccountNumber(final String accountNumber) throws InvalidArgumentException, NullArgumentException
    {
        accountNumberValidator.validate(accountNumber);
        return accountsRepository.findByAccountNumber(accountNumber);
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

        return accountsRepository.cancelPayment(account, dummyPendingPayment);
    }

    @Override
    public PendingPayment createPendingPayment(final Account account, final PendingPayment pendingPayment) throws InvalidArgumentException, NullArgumentException
    {
        pendingPaymentValidator.validate(pendingPayment);
        return accountsRepository.createPendingPayment(account, pendingPayment);
    }

    @Override
    public Account updatePersonalDetails(final Account account, final PersonalDetails personalDetails) throws InvalidArgumentException, NullArgumentException
    {
        personalDetailsValidator.validate(personalDetails);
        account.setPersonalDetails(personalDetails);
        return accountsRepository.update(account);
    }
}
