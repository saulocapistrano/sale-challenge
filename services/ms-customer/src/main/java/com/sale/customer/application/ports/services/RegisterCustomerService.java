package com.sale.customer.application.ports.services;

import com.sale.customer.application.ports.in.RegisterCustomerUseCase;
import com.sale.customer.domain.model.Customer;
import com.sale.customer.domain.repository.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class RegisterCustomerService implements RegisterCustomerUseCase {

    @Inject
    CustomerRepository customerRepository;

    @Override
    public Customer execute(Customer customer) {
        // Verifica se já existe cliente com o mesmo e-mail
        customerRepository.findByEmail(customer.getEmail())
                .ifPresent(existing -> {
                    throw new RuntimeException("Customer already exists with this email.");
                });

        // Define um novo UUID (simulação — futuramente movemos para entidade ou evento)
        customer.setId(UUID.randomUUID());
        customer.setActive(true);

        return customerRepository.save(customer);
    }
}
