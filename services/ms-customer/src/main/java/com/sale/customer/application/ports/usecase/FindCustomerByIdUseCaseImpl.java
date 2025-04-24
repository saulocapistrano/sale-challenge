package com.sale.customer.application.ports.usecase;

import com.sale.customer.application.ports.in.FindCustomerByIdUseCase;
import com.sale.customer.application.ports.out.CustomerRepositoryPort;
import com.sale.customer.domain.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    @Inject
    CustomerRepositoryPort customerRepositoryPort;

    @Override
    public Optional<Customer> execute(UUID id){
        return customerRepositoryPort.findById(id);
    }
}
