package com.sale.customer.adapters.in.rest.mapper;

import com.sale.customer.adapters.in.rest.dto.CustomerResponseDTO;
import com.sale.customer.adapters.out.persistence.entity.CustomerEntity;
import com.sale.customer.domain.model.Customer;


public class CustomerMapper {


    public static Customer toDomain(CustomerEntity entity) {
        return Customer.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .cpf(entity.getCpf())
                .active(entity.isActive())
                .build();
    }


    public static CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .cpf(customer.getCpf())
                .active(customer.isActive())
                .build();
    }

    public static void updateEntity(CustomerEntity entity, Customer customer) {
        entity.setName(customer.getName());
        entity.setEmail(customer.getEmail());
        entity.setCpf(customer.getCpf());
        entity.setActive(customer.isActive());
    }

    public static CustomerResponseDTO toResponseDTO(Customer customer){
        return CustomerResponseDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .cpf(customer.getCpf())
                .email(customer.getEmail())
                .active(customer.isActive())
                .build();
    }

}
