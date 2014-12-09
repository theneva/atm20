package no.meccano.api.authentication;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class AuthenticationRequestFilter implements ContainerRequestFilter
{
    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException
    {
        System.out.println("Authorization header: " + requestContext.getHeaderString("Authorization"));
    }
}
