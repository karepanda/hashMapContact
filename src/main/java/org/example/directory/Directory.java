package org.example.directory;

import lombok.ToString;
import org.example.contact.Contact;
import org.example.exception.ContactException;

import java.util.HashMap;

@ToString
public class Directory {
    private static HashMap<String, Contact> contactMap = new HashMap<>();

    public static Contact addContact (Contact contact) {
        contactValidation(contact);

        contactMap.put(contact.getName(), contact);

        return findContactByName(contact.getName());
    }

    public static Contact findContactByName(String name){
        final Contact contact = contactMap.get(name);

        contactValidation(contact);

        return contact;
    }

    public static void deleteContactByName(String name){

        if (name == null || contactMap.remove(name) == null){
            throw new ContactException("The contact does not exist");
        }

    }

    public static Contact updateContactPhoneNumber(String name, int phoneNumber){
        final Contact contact = contactMap.get(name);

        contactValidation(contact);

        contact.setPhoneNumber(phoneNumber);

        return findContactByName(contact.getName());
    }

    private static void contactValidation(Contact contact) {
        if (contact == null){
            throw new ContactException("The contact can't be null");
        }
    }


}
