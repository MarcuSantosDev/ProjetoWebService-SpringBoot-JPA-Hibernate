package com.cursojava.projetowebservice.services.exceptions;

public class DatabaseException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public DatabaseException(String message) {
        super(message);
    }
}
