package org.example.directory;

import lombok.ToString;
import org.example.contact.Contact;
import org.example.exception.ContactException;

import java.util.HashMap;

@ToString
public class Directory {
    private static HashMap<String, Contact> directory = new HashMap<>();

    public static Contact addContact (Contact contact) {
        if (contact == null){
            throw new ContactException("The contact can't be null");
        }
        directory.put(contact.getName(), contact);

        return directory.get(contact.getName());
    }

}
