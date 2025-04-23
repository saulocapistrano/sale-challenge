package com.sale.customer.domain.vo;

import java.util.Objects;

public final class Email {

    private final String value;

    public Email(String value) {
        if (value == null || !value.matches("^[\\w\\.-]+@[\\w\\.-]+\\.[a-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email.");
        }
        this.value = value.toLowerCase();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return value.equals(email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
