package no.meccano.api;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultExceptionMapper implements ExceptionMapper<NotFoundException>
{
    @Override
    public Response toResponse(final NotFoundException exception)
    {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
