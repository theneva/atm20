package no.meccano.data;

import no.meccano.domain.account.Account;
import no.meccano.domain.account.PendingPayment;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
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
        accounts.put(martinAccountNumber, new Account("Martin", null, "Lehmann", "Skogvollveien 36", "0580", "Oslo", "Oslo", "Norway", martinAccountNumber, 47589, "1234", new ArrayList<>()));
        accounts.put(andreasAccountNumber, new Account("Andreas", null, "Biørn-Hansen", "Bråtenlia 9D", "1929", "Auli", "Akershus", "Norway", andreasAccountNumber, 439, "5555", Arrays.asList(
                new PendingPayment("2014-12-10", 437, "12312312312", "Øl til Martin"),
                new PendingPayment("2014-12-14", 100, "27834793902", "Salt Sild")

        )));
    }

    @Override
    public Account findByAccountNumber(final String accountNumber)
    {
        return accounts.get(accountNumber);
    }
}
