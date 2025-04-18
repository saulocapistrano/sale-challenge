package com.sale.customer.adapters.out.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    private boolean active;
}
