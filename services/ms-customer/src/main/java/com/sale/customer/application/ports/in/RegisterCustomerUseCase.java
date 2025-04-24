package com.sale.customer.application.ports.in;

import com.sale.customer.domain.model.Customer;

public interface RegisterCustomerUseCase {

    Customer execute(Customer customer);

}
