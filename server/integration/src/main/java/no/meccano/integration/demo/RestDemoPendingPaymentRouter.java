package no.meccano.integration.demo;

import no.meccano.domain.account.payment.PendingPayment;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
public class RestDemoPendingPaymentRouter implements PendingPaymentRouter
{
    @Override
    public PendingPayment getPendingPaymentById(final String id)
    {
        final Client client = ClientBuilder.newClient();

        final WebTarget target = client.target("http://localhost:4321");
        final Response response = target.request(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .post(Entity.entity("{\"id\": \"3E0E6762-C942-48FD-9E97-7184DABEB29D\"}", MediaType.APPLICATION_JSON));

        System.out.println(response.getEntity());

        return null;
    }
}
