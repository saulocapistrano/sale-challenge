package com.sale.customer.application.ports.services;


import com.sale.customer.application.ports.in.ListCustomersUseCase;
import com.sale.customer.application.ports.out.CustomerRepositoryPort;
import com.sale.customer.domain.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ListCustomersService implements ListCustomersUseCase {


    @Inject
    CustomerRepositoryPort customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
