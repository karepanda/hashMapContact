package org.example.exception;

public class ContactException extends RuntimeException{
    public ContactException (String messageError) {
        super(messageError);
    }
}
