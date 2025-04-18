package com.sale.customer.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private UUID id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email
    @NotBlank(message = "Mail is required")
    private String email;

    @NotBlank(message = "Cpf is required")
    @CPF
    private String cpf;

    private boolean active;
}
