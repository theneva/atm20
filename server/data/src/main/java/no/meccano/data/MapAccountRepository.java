package no.meccano.data;

import no.meccano.domain.Account;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class MapAccountRepository implements AccountRepository
{
    private final Map<String, Account> accounts = new HashMap<>();

    public MapAccountRepository()
    {
        String martinAccountNumber = "12345678";
        String andreasAccountNumber = "87654321";
        accounts.put(martinAccountNumber, new Account("Martin", null, "Lehmann", "Skogvollveien 36", "0580", "Oslo", "Oslo", "Norway", martinAccountNumber, 47589, "1234"));
        accounts.put(andreasAccountNumber, new Account("Andreas", null, "Biørn-Hansen", "Bråtenlia 9D", "1929", "Auli", "Akershus", "Norway", "87654321", 439, "4321"));
    }

    @Override
    public Account findByAccountNumber(final String accountNumber)
    {
        return accounts.get(accountNumber);
    }
}
