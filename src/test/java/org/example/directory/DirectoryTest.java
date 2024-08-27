package org.example.directory;

import org.example.contact.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DirectoryTest {
    @Test
    void givenContactWhenAddContactIsNullThenReturnContactException() {
        Directory.addContact(null);
    }

    @Test
    @DisplayName("Throw ContactException with message name not null")
    void givenContactWhenNameIsNullThenThrowException(){

    }
    @Test
    @DisplayName("Throw ContactException with message phoneNumber not null")
    void givenContactWhenPhoneIsNullThenThrowException(){

    }

    @Test
    void givenContactWhenContactIsValidThenReturnContact(){
        Contact contactExpected= Contact.builder()
                .name("name")
                .phoneNumber(0)
                .build();
        Contact result = Directory.addContact(contactExpected);

        assertEquals(contactExpected,result);
    }
}