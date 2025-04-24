package com.sale.customer.application.ports.in;

import com.sale.customer.domain.model.Customer;

import java.util.List;

public interface ListCustomersUseCase {

    List<Customer> execute();
}
