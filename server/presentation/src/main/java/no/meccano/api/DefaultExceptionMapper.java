package no.meccano.api;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Throwable>
{
    @Override
    public Response toResponse(final Throwable exception)
    {
        if (exception instanceof NotFoundException) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        System.out.println("DefaultExceptionMapper caught exception: " + exception);
        return Response.serverError().build();
    }
}
