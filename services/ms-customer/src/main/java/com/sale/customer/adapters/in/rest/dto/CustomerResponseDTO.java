package com.sale.customer.adapters.in.rest.dto;

import com.sale.customer.domain.vo.Email;

import java.util.UUID;

public class CustomerResponseDTO {
    private UUID id;
    private String name;
    private Email email;
    private String cpf;
}
