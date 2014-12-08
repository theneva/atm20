package no.meccano.data;

import no.meccano.domain.account.Account;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class MapAccountRepository implements AccountRepository
{
    private final Map<String, Account> accounts = new HashMap<>();

    public MapAccountRepository()
    {
        String martinAccountNumber = "12312312312";
        String andreasAccountNumber = "55555555555";
        accounts.put(martinAccountNumber, new Account("Martin", null, "Lehmann", "Skogvollveien 36", "0580", "Oslo", "Oslo", "Norway", martinAccountNumber, 47589, "1234"));
        accounts.put(andreasAccountNumber, new Account("Andreas", null, "Biørn-Hansen", "Bråtenlia 9D", "1929", "Auli", "Akershus", "Norway", andreasAccountNumber, 439, "5555"));
    }

    @Override
    public Account findByAccountNumber(final String accountNumber)
    {
        return accounts.get(accountNumber);
    }
}
