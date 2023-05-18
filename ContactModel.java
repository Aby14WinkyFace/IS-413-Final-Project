package com.example.mvcfinal_2023;


import java.util.ArrayList;
import java.util.List;

public class ContactModel {
    private List<PersonEntry> contacts;

    public ContactModel() {
        contacts = new ArrayList<>();
    }

    public void addContact(PersonEntry contact) {
        contacts.add(contact);
    }

    public void removeContact(PersonEntry contact) {
        contacts.remove(contact);
    }
    public void editContact(PersonEntry contact, String newName, String newEmail,
                            String newPhoneNumber, String newEmailS) {
        int index = contacts.indexOf(contact);
        if (index != -1) {
            contact.setName(newName);
            contact.setEmail(newEmail);
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmailS(newEmailS);
            contacts.set(index, contact);
        }
    }

    public List<PersonEntry> getContacts() {
        return contacts;
    }
}
