package no.meccano.data;

import no.meccano.domain.Account;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class ListAccountRepository implements AccountRepository
{
    private final List<Account> accounts = Arrays.asList(
            new Account("Martin", null, "Lehmann", "Skogvollveien 36", "0580", "Oslo", "Oslo", "Norway", "12345678", 47589, "1234"),
            new Account("Andreas", null, "Biørn-Hansen", "Bråtenlia 9D", "1929", "Auli", "Akershus", "Norway", "87654321", 439, "4321")
    );

    @Override
    public Account findByAccountNumber(final String accountNumber)
    {
        Account matchedAccount = null;

        for (final Account account : accounts)
        {
            if (account.getAccountNumber().equals(accountNumber))
            {
                matchedAccount = account;
                break;
            }
        }

        System.out.println("returning account: " + matchedAccount);
        return matchedAccount;
    }
}
