package com.sale.customer.application.ports.usecase;

import com.sale.customer.application.ports.out.CustomerRepositoryPort;
import com.sale.customer.domain.exception.EmailAlreadyExistsException;
import com.sale.customer.domain.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class RegisterCustomerUseCaseImpl implements com.sale.customer.application.ports.in.RegisterCustomerUseCase {

    @Inject
    CustomerRepositoryPort customerRepository;

    @Override
    @Transactional
    public Customer execute(Customer customer) {
        customerRepository.findByEmail(customer.getEmail())
                .ifPresent(existing -> {
                    throw new EmailAlreadyExistsException(customer.getEmail());
                });

        customer.setId(UUID.randomUUID());
        customer.setActive(true);

        return customerRepository.save(customer);
    }
}
