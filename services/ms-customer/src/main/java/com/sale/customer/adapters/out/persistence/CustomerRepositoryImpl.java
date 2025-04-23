package com.sale.customer.adapters.out.persistence;

import com.sale.customer.adapters.in.rest.mapper.CustomerMapper;
import com.sale.customer.adapters.out.persistence.entity.CustomerEntity;
import com.sale.customer.application.ports.out.CustomerRepositoryPort;
import com.sale.customer.domain.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerRepositoryImpl implements CustomerRepositoryPort {

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = CustomerMapper.toEntity(customer);
        entity.persist();
        return CustomerMapper.toDomain(entity);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return CustomerEntity.findByIdOptional(id)
                .map(e -> CustomerMapper.toDomain((CustomerEntity) e));
    }

    @Override
    public List<Customer> findAll() {
        return CustomerEntity.listAll().stream()
                .map(e -> CustomerMapper.toDomain((CustomerEntity) e))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        CustomerEntity.deleteById(id);
    }

    @Override
    public void deleteById(UUID id) {
        CustomerEntity.deleteById(id);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return CustomerEntity.find("email", email).firstResultOptional()
                .map(e -> CustomerMapper.toDomain((CustomerEntity) e));
    }
}
