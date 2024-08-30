package org.example.directory;

import org.example.contact.Contact;
import org.example.exception.ContactException;
import org.junit.jupiter.api.DisplayName;
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
    void givenContactWhenFindContactByNameIsNullThenThrowsException(){
       //Act & Assert
        assertThrows(ContactException.class, () ->Directory.findContactByName("null"));
    }

    @Test
    void givenContactWhenFindContactByNameDoesNotExistThenThrowsContactException(){

        //Arrange
        Contact contactExpected = Contact.builder()
                .name("name1")
                .phoneNumber(0)
                .build();
        Directory.addContact(contactExpected);

        //Act and Assert
        assertThrows(ContactException.class, () -> Directory.findContactByName("name"));

    }

    @Test
    void givenContactWhenFindContactByNameIsEmptyThenThrowsException(){
        //Act & Assert
        assertThrows(ContactException.class, () -> Directory.findContactByName(""));
    }

    @Test
    void givenContactWhenFindContactByNameExistThenReturnContact(){
        //Arrange
        Contact contactExpected= Contact.builder()
                .name("name")
                .phoneNumber(0)
                .build();
        Directory.addContact(contactExpected);

        Contact contactExpected2 = Contact.builder()
                .name("name2")
                .phoneNumber(0)
                .build();
        Directory.addContact(contactExpected2);

        //Act
        Contact result = Directory.findContactByName("name");

        //Assert
        assertEquals(contactExpected,result);

    }

    @Test
    @DisplayName("When removed throws Exception because the contact doesn't exist anymore")
    void givenContactWhenDeleteContactByNameExistThenRemoved(){
        //Arrange
        final String nameExpected = "name";
        Contact contactExpected= Contact.builder()
                .name(nameExpected)
                .phoneNumber(0)
                .build();
        Directory.addContact(contactExpected);

        //Act
        Directory.deleteContactByName(nameExpected);

        //Assert
        assertThrows(ContactException.class, () -> Directory.findContactByName(nameExpected));

    }

    @Test
    void givenContactWhenDeleteContactByNameIsEmptyThenReturnException(){
        //Act & Assert
        assertThrows(ContactException.class, () -> Directory.deleteContactByName(""));
    }

    @Test
    void givenContactWhenDeleteContactByNameIsNullThenReturnException(){
        //Act & Assert
        assertThrows(ContactException.class, () -> Directory.deleteContactByName(null));
    }

    @Test
    void givenContactWhenUpdateContactPhoneNumberIsEmptyThenReturnException(){
        //Act & Assert
        assertThrows(ContactException.class, () -> Directory.updateContactPhoneNumber("", 0));
    }

    @Test
    void givenContactWhenUpdateContactPhoneNumberIsNullThenReturnException(){
        //Act & Assert
        assertThrows(ContactException.class, () -> Directory.updateContactPhoneNumber(null,0));
    }

    @Test
    void givenContactWhenUpdateContactPhoneNumberExistsThenReturnContact(){
        //Arrange
        final String nameExpected = "name";
        Contact contactExpected= Contact.builder()
                .name(nameExpected)
                .phoneNumber(0)
                .build();
        Directory.addContact(contactExpected);

        //Act
        Directory.updateContactPhoneNumber(nameExpected,123);
        Contact result = Directory.findContactByName(nameExpected);

        //Assert
        assertEquals(123, result.getPhoneNumber());
    }

}