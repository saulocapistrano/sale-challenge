package com.sale.customer.adapters.in.rest;

import com.sale.customer.adapters.in.rest.dto.CustomerRequestDTO;
import com.sale.customer.application.ports.in.RegisterCustomerUseCase;
import com.sale.customer.domain.model.Customer;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {

    @Inject
    RegisterCustomerUseCase customerUseCase;

    // POST /customers
    @POST
    public Response createCustomer(@Valid CustomerRequestDTO request) {
        Customer customer = Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .cpf(request.getCpf())
                .build();

        Customer saved = customerUseCase.execute(customer);

        return Response.status(Response.Status.CREATED).entity(saved).build();
    }

    // GET /customers
    @GET
    public Response findAll() {
        List<Customer> customers = List.of(); // Vamos implementar isso depois
        return Response.ok(customers).build();
    }

    // GET /customers/{id}
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id) {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    // DELETE /customers/{id}
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") UUID id) {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
