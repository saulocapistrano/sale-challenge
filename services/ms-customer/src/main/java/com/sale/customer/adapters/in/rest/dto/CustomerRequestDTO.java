package com.sale.customer.adapters.in.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class CustomerRequestDTO {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private com.sale.customer.domain.vo.Email email;

    @CPF
    @NotBlank
    private String cpf;
}
