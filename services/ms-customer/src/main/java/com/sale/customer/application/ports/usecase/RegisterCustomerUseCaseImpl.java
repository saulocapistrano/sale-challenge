package com.sale.customer.application.ports.usecase;

import com.sale.customer.application.ports.out.CustomerRepositoryPort;
import com.sale.customer.domain.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class RegisterCustomerUseCaseImpl implements com.sale.customer.application.ports.in.RegisterCustomerUseCase {

    @Inject
    CustomerRepositoryPort customerRepository;

    @Override
    public Customer execute(Customer customer) {
        customerRepository.findByEmail(customer.getEmail())
                .ifPresent(existing -> {
                    throw new RuntimeException("Customer already exists with this email.");
                });

        customer.setId(UUID.randomUUID());
        customer.setActive(true);

        return customerRepository.save(customer);
    }
}
