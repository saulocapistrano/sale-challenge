package com.sale.customer.application.ports.usecase;

import com.sale.customer.application.ports.in.DeleteCustomerUseCase;
import com.sale.customer.application.ports.out.CustomerRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    @Inject
    CustomerRepositoryPort customerRepositoryPort;

    @Override
    @Transactional
    public void execute(UUID id){
        customerRepositoryPort.delete(id);
    }
}
