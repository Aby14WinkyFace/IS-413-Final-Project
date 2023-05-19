package com.example.mvcfinal_2023;

import java.util.ArrayList;
import java.util.List;

public class ContactModel {
    List<PersonEntry> contacts;

    public ContactModel() {
        contacts = new ArrayList<>();
    }

    public void addContact(PersonEntry contact) {
        contacts.add(contact);
    }

    public void removeContact(PersonEntry contact) {
        contacts.remove(contact);
    }
    public void editContact(PersonEntry contact, String newFirstName, String newLastName,
                            Long newPhoneNumber, String newPriEmail, String newSecEmail ) {
        int index = contacts.indexOf(contact);
        if (index != -1) {
            contact.setFName(newFirstName);
            contact.setLName(newLastName);
            contact.setPriEmail(newPriEmail);
            contact.setSecEmail(newSecEmail);
            contact.setPhoneNumber(newPhoneNumber);
            contacts.set(index, contact);
        }
    }

    public List<PersonEntry> getContacts() {
        return contacts;
    }
}
