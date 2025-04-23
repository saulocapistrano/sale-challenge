package com.sale.customer.infrastructure.config;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.xml.bind.ValidationException;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        if (ex instanceof ValidationException) {
            return Response.status((Response.Status.BAD_REQUEST))
                    .entity(ex.getMessage()).build();

        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ex.getMessage()).build();
    }
}