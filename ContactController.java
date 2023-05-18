package com.example.mvcfinal_2023;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class ContactController {
    private ContactModel contactModel;
    private TableView<PersonEntry> tableView;

    public ContactController(ContactModel contactModel, TableView<PersonEntry> tableView) {
        this.contactModel = contactModel;
        this.tableView = tableView;
        bindTableView();
    }

    private void bindTableView() {
        ObservableList<PersonEntry> contactList = FXCollections.observableArrayList(contactModel.getContacts());
        tableView.setItems(contactList);
    }

    public void addContact(PersonEntry contact) {
        contactModel.addContact(contact);
    }

    public void removeContact(PersonEntry contact) {
        contactModel.removeContact(contact);
    }

    public void saveContactsToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (PersonEntry contact : contactModel.getContacts()) {
                writer.println(contact.getName() + "," + contact.getEmail() + "," + contact.getPhoneNumber());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
