package no.meccano.data;

import no.meccano.domain.account.Account;
import no.meccano.domain.account.payment.PendingPayment;

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
        accounts.put(andreasAccountNumber, new Account("Andreas", null, "Biørn-Hansen", "Bråtenlia 9D", "1929", "Auli", "Akershus", "Norway", andreasAccountNumber, 439, "5555", new ArrayList<>(Arrays.asList(
                new PendingPayment("23423423", "2014-12-10", 437, "12312312312", "Øl til Martin"),
                new PendingPayment("324322", "2014-12-14", 100, "27834793902", "Salt Sild"),
                new PendingPayment("24343222", "2014-12-14", 100, "27834793902", "Pai"),
                new PendingPayment("56453345", "2014-12-14", 100, "27834793902", "McDonald's"),
                new PendingPayment("6756763454", "2014-12-14", 100, "27834793902", "Chess"),
                new PendingPayment("198293", "2014-12-14", 100, "27834793902", "Husleie"),
                new PendingPayment("58439892", "2014-12-14", 100, "27834793902", "Ananas"),
                new PendingPayment("4902", "2014-12-14", 100, "27834793902", "Eple"),
                new PendingPayment("892348932894", "2014-12-14", 100, "27834793902", "Plantegninger"),
                new PendingPayment("34728972", "2014-12-14", 5439, "78378493842", "Ny telefon")
        ))));
    }

    @Override
    public Account findByAccountNumber(final String accountNumber)
    {
        return accounts.get(accountNumber);
    }

    @Override
    public PendingPayment cancelPayment(final Account account, final PendingPayment pendingPayment)
    {
        return account.getPendingPayments().remove(account.getPendingPayments().indexOf(pendingPayment));
    }

    @Override
    public PendingPayment createPendingPayment(final Account account, final PendingPayment pendingPayment)
    {
        account.getPendingPayments().add(pendingPayment);
        return pendingPayment;
    }
}
