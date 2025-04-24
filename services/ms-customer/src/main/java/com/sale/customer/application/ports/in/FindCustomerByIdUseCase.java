package com.sale.customer.application.ports.in;

import com.sale.customer.domain.model.Customer;

import java.util.Optional;
import java.util.UUID;

public interface FindCustomerByIdUseCase {
    Optional<Customer> execute(UUID id);
}
