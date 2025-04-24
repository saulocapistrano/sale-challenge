package com.sale.customer.adapters.in.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class CustomerRequestDTO {

    @NotBlank
    private String name;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @CPF
    @NotBlank
    private String cpf;
}
