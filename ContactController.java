package com.example.mvcfinal_2023;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ContactController {
    private ContactModel contactModel;
    private TableView<PersonEntry> tableView;
    private ContactView contactView;

    private String filename = "src/main/resources/project/final_project/SavedContacts.txt";

    public ContactController(ContactModel contactModel, TableView<PersonEntry> tableView, ContactView contactView) {
        this.contactModel = contactModel;
        this.tableView = tableView;
        this.contactView = contactView;
        bindTableView();
        setupButtonHandlers();
    }

    private void bindTableView() {
        ObservableList<PersonEntry> contactList = FXCollections.observableArrayList(contactModel.getContacts());
        tableView.setItems(contactList);
    }

    public void saveContactsToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (PersonEntry contact : contactModel.getContacts()) {
                writer.println(contact.getFName() + "," +
                                contact.getLName() + "," +
                                contact.getPhoneNumber() + "," +
                                contact.getPriEmail()+ "," +
                                contact.getSecEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setupButtonHandlers() {
        contactView.getBtnAdd().setOnAction(e -> {
            String firstName = contactView.tfFirstName.getText();
            String lastName = contactView.tfLastName.getText();
            long phoneNumber = Long.parseLong(contactView.tfPhoneNumber.getText());
            String primaryEmail = contactView.tfFirstEmail.getText();
            String secondaryEmail = contactView.tfSecondEmail.getText();

            PersonEntry newEntry = new PersonEntry(firstName, lastName, phoneNumber, primaryEmail, secondaryEmail);

            contactModel.addContact(newEntry);

            contactView.tfFirstName.clear();
            contactView.tfLastName.clear();
            contactView.tfPhoneNumber.clear();
            contactView.tfFirstEmail.clear();
            contactView.tfSecondEmail.clear();

            tableView.setItems(FXCollections.observableArrayList(contactModel.contacts));
            tableView.refresh();
        });

        contactView.getBtnEdit().setOnAction(e -> {
            PersonEntry selectedEntry = tableView.getSelectionModel().getSelectedItem();

            if (selectedEntry != null) {

                String firstName = contactView.tfFirstName.getText();
                String lastName = contactView.tfLastName.getText();
                long phoneNumber = Long.parseLong(contactView.tfPhoneNumber.getText());
                String primaryEmail = contactView.tfFirstEmail.getText();
                String secondaryEmail = contactView.tfSecondEmail.getText();

                contactModel.editContact(selectedEntry, firstName, lastName, phoneNumber, primaryEmail, secondaryEmail);

                contactView.tfFirstName.clear();
                contactView.tfLastName.clear();
                contactView.tfPhoneNumber.clear();
                contactView.tfFirstEmail.clear();
                contactView.tfSecondEmail.clear();

                tableView.refresh();
            }
        });

        contactView.getBtnDelete().setOnAction(e -> {

            PersonEntry selectedEntry = tableView.getSelectionModel().getSelectedItem();
            if (selectedEntry != null) {
                contactModel.removeContact(selectedEntry);
            }
            tableView.setItems(FXCollections.observableArrayList(contactModel.contacts));
            tableView.refresh();
        });

        contactView.getBtnSave().setOnAction(e -> {
            saveContactsToFile(filename);
        });
    }

    List<PersonEntry> readContactsFromFile() {
        List<PersonEntry> loadContacts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    long phoneNumber = Long.parseLong(parts[2].trim());
                    String primaryEmail = parts[3].trim();
                    String secondaryEmail = parts[4].trim();

                    PersonEntry newEntry = new PersonEntry(firstName, lastName, phoneNumber, primaryEmail, secondaryEmail);
                    loadContacts.add(newEntry);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadContacts;
    }
}
