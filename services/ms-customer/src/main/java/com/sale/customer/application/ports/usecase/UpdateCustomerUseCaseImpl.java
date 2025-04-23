package com.sale.customer.application.ports.usecase;

import com.sale.customer.application.ports.in.UpdateCustomerUseCase;
import com.sale.customer.application.ports.out.CustomerRepositoryPort;
import com.sale.customer.domain.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    @Inject
    CustomerRepositoryPort customerRepository;

    @Override
    public Customer execute(Customer customer) {
        UUID id = customer.getId();

        if (id == null || customerRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Customer not found");
        }

        return customerRepository.save(customer);
    }

}
