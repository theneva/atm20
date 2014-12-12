package no.meccano.business;

import no.meccano.data.MapAccountsRepository;
import no.meccano.domain.account.Account;
import no.meccano.domain.account.DefaultAccountNumberValidator;
import no.meccano.domain.account.DefaultPersonalDetailsValidator;
import no.meccano.domain.account.PersonalDetails;
import no.meccano.domain.account.payment.DefaultPendingPaymentValidator;
import no.meccano.domain.account.payment.PendingPayment;
import no.meccano.domain.common.InvalidArgumentException;
import no.meccano.domain.common.NullArgumentException;
import no.meccano.integration.DefaultAccountsRouter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountsServiceTest
{
    private AccountsService accountsService;

    private final Account availableAccount = new Account(
            new PersonalDetails("John", "Doe", "Alleyway 23", "0580", "Oslo", "Oslo"),
            "12345678901",
            124839,
            "1111",
            new ArrayList<PendingPayment>()
    );

    @Before
    public void setUp()
    {
        // Mock an accounts router that can return an account with the account number "12345678901".
        final MapAccountsRepository mockedAccountsRepository = mock(MapAccountsRepository.class);
        when(mockedAccountsRepository.findByAccountNumber("12345678901"))
                .thenReturn(availableAccount);

        // Anything except the predefined account number.
        when(mockedAccountsRepository.findByAccountNumber(matches("[0|2-9a-zA-Z][0-9a-zA-Z]{10}")))
                .thenReturn(null);

        accountsService = new DefaultAccountsService(
                new DefaultAccountNumberValidator(),
                new DefaultAccountsRouter(mockedAccountsRepository),
                new DefaultPendingPaymentValidator(),
                new DefaultPersonalDetailsValidator()
        );
    }

    @Test
    public void testFindByAccountNumber() throws NullArgumentException, InvalidArgumentException
    {
        final Account matchedAccount = accountsService.findByAccountNumber(
                availableAccount.getAccountNumber());

        Assert.assertEquals(
                matchedAccount.getAccountNumber(),
                availableAccount.getAccountNumber());
    }
}

