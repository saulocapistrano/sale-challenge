package com.sale.customer.application.ports.out;

import com.sale.customer.domain.model.Customer;
import com.sale.customer.domain.vo.Email;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepositoryPort {
    Customer save(Customer customer);
    Optional<Customer> findById(UUID id);
    List<Customer> findAll();
    void delete(UUID id);
    void deleteById(UUID id);
    Optional<Customer> findByEmail(Email email);
}
