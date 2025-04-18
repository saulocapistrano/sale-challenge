package com.sale.customer.domain.repository;


import com.sale.customer.domain.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Customer save(Customer customer);

    Optional<Customer> findById(UUID id);

    List<Customer> findAll();

    void delete(UUID id);

    void deleteById(UUID id);

    Optional<Customer> findByEmail(String email);


}
