package no.meccano.domain.account.payment;

import no.meccano.domain.account.AccountNumberValidator;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DefaultPendingPaymentValidator implements PendingPaymentValidator
{
    @Inject
    private AccountNumberValidator accountNumberValidator;

    @Override
    public void validate(final PendingPayment pendingPayment) throws NullArgumentException, InvalidArgumentException
    {
        if (pendingPayment == null)
        {
            throw new NullArgumentException("pendingPayment");
        }

        if (pendingPayment.getId() == null)
        {
            throw new NullArgumentException("pendingPayment.id");
        }

        if (pendingPayment.getKid() == null)
        {
            throw new NullArgumentException("pendingPayment.kid");
        }

        if (!pendingPayment.getKid().matches("[0-9]{2,17}"))
        {
            throw new InvalidArgumentException(pendingPayment.getKid(), "KID must be 2-17 digits");
        }

        if (pendingPayment.getAmount() <= 0)
        {
            throw new InvalidArgumentException(pendingPayment.getAmount(), "Amount must be greater than 0");
        }

        if (pendingPayment.getDueDate() == null)
        {
            throw new NullArgumentException("pendingPayment.dueDate");
        }

        if (!pendingPayment.getDueDate().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
        {
            throw new InvalidArgumentException(pendingPayment.getDueDate(), "Due date must be on the format XXXX-XX-XX where each X is a digit.");
        }

        accountNumberValidator.validate(pendingPayment.getRecipientAccountNumber());

        if (pendingPayment.getRecipientNickname() == null)
        {
            throw new NullArgumentException("pendingPayment.recipientNickname");
        }

        if (pendingPayment.getRecipientNickname().trim().length() == 0)
        {
            throw new InvalidArgumentException(pendingPayment.getRecipientNickname(), "Recipient nickname must be at least 1 character long, and not only whitespace.");
        }
    }
}
