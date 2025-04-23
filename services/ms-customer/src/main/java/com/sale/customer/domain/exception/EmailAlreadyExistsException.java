package com.sale.customer.domain.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String email) {
        super("A customer already exists with the email: " + email);
    }
}
