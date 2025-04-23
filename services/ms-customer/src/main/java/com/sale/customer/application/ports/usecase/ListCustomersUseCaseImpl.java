package com.sale.customer.application.ports.usecase;


import com.sale.customer.application.ports.out.CustomerRepositoryPort;
import com.sale.customer.domain.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ListCustomersUseCaseImpl implements com.sale.customer.application.ports.in.ListCustomersUseCase {


    @Inject
    CustomerRepositoryPort customerRepository;

    @Override
    public List<Customer> execute () {
        return customerRepository.findAll();
    }
}
