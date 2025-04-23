package com.sale.customer.domain.model;

import com.sale.customer.domain.vo.Email;
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

    @NotBlank(message = "Mail is required")
    private com.sale.customer.domain.vo.Email email;

    @NotBlank(message = "Cpf is required")
    @CPF
    private String cpf;

    private boolean active;

    public Builder email(Email email) {
        this.email = email;
        return (Builder) this;
    }

}
