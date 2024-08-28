package org.example.directory;

import org.example.contact.Contact;
import org.example.exception.ContactException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    @Test
    void givenContactWhenAddContactIsNullThenReturnContactException() {
        //Act and Assert
        assertThrows(ContactException.class, ()->Directory.addContact(null));
    }

    @Test
    void givenContactWhenContactIsValidThenReturnContact(){
        //Arrange
        Contact contactExpected= Contact.builder()
                .name("name")
                .phoneNumber(0)
                .build();

        //Act
        Contact result = Directory.addContact(contactExpected);

        //Assert
        assertEquals(contactExpected,result);
    }

    @Test
    void givenContactSearchWhenContactIsNullThenThrowsException(){
        //Act and Assert
        assertThrows(ContactException.class, () ->Directory.search(null));
    }

    @Test
    void givenContactSearchWhenContactDoesNotExistThenReturnFalse(){
        Contact contactExpected= Contact.builder()
                .name("name")
                .phoneNumber(0)
                .build();

        boolean result = Directory.search(contactExpected);

        //Assert
        assertFalse(result);

    }

    @Test
    void givenContactSearchWhenContactExistThenReturnTrue(){
        Contact contactExpected= Contact.builder()
                .name("name")
                .phoneNumber(0)
                .build();
        Contact result = Directory.addContact(contactExpected);

        //Assert
        assertTrue(Directory.search(result));

    }

}