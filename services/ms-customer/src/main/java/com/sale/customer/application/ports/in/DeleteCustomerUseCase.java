package com.sale.customer.application.ports.in;

import java.util.UUID;

public interface DeleteCustomerUseCase {
    void execute(UUID id);
}
