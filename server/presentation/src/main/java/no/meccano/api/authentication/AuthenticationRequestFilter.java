package no.meccano.api.authentication;

import no.meccano.business.SessionsService;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class AuthenticationRequestFilter implements ContainerRequestFilter
{
    @Inject
    private SessionsService sessionsService;

    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException
    {
//        if ("OPTIONS".equals(requestContext.getMethod()))
//        {
//            // Angular stuff.
//            return;
//        }
//
//        if (requestContext.getUriInfo().getPath().equals(SessionsResource.PATH) && requestContext.getMethod().equals("POST"))
//        {
//            return;
//        }
//
//        final String token = requestContext.getHeaderString("Authorization");
//        try
//        {
//            sessionsService.findByToken(token);
//        }
//        catch (InvalidArgumentException | NullArgumentException e)
//        {
//            requestContext.abortWith(
//                    Response.status(Response.Status.BAD_REQUEST)
//                            .type(MediaType.APPLICATION_JSON)
//                            .entity(new ErrorResponse(e.getMessage()))
//                            .build());
//        }
//        catch (NoSuchSessionException e)
//        {
//            requestContext.abortWith(
//                    Response.status(Response.Status.UNAUTHORIZED)
//                            .type(MediaType.APPLICATION_JSON)
//                            .entity(new ErrorResponse(e.getMessage()))
//                            .build());
//        }
    }
}
