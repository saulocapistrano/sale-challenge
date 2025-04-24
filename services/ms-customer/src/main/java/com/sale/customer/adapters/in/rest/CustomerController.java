package com.sale.customer.adapters.in.rest;

import com.sale.customer.adapters.in.rest.dto.CustomerRequestDTO;
import com.sale.customer.adapters.in.rest.dto.CustomerResponseDTO;
import com.sale.customer.adapters.in.rest.mapper.CustomerMapper;
import com.sale.customer.application.ports.in.*;
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

    @Inject
    ListCustomersUseCase listCustomersUseCase;

    @Inject
    FindCustomerByIdUseCase findCustomerByIdUseCase;
    @Inject
    DeleteCustomerUseCase deleteCustomerUseCase;
    @Inject
    UpdateCustomerUseCase updateCustomerUseCase;


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

    @GET
    public Response findAll() {
        List<CustomerResponseDTO> customers = listCustomersUseCase.execute()
                .stream()
                .map(CustomerMapper::toResponseDTO)
                .toList();

        return Response.ok(customers).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id) {
        return findCustomerByIdUseCase.execute(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") UUID id, @Valid CustomerRequestDTO request) {
        Customer customer = Customer.builder()
                .id(id)
                .name(request.getName())
                .email(request.getEmail())
                .cpf(request.getCpf())
                .active(true)
                .build();

        Customer updated = updateCustomerUseCase.execute(customer);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") UUID id) {
        deleteCustomerUseCase.execute(id);
        return Response.noContent().build();
    }
}
