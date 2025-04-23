package com.sale.customer.adapters.in.rest.dto;

import com.sale.customer.domain.vo.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private UUID id;
    private String name;
    private Email email;
    private String cpf;
    private boolean active;

}
