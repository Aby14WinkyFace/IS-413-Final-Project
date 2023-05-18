package com.example.mvcfinal_2023;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;


public class ContactView extends Application{

    private TableView<PersonEntry> tableView;
    private ContactModel contactModel;

    @Override
    public void start(Stage stage){

        contactModel = new ContactModel();

        TableView table = new TableView<PersonEntry>();

        final ObservableList<PersonEntry> data =
                FXCollections.observableArrayList(
                        new PersonEntry("Jacob", "Smith", "jacob.smith@example.com"),
                        new PersonEntry("Isabella", "Johnson", "isabella.johnson@example.com"),
                        new PersonEntry("Ethan", "Williams", "ethan.williams@example.com"),
                        new PersonEntry("Emma", "Jones", "emma.jones@example.com"),
                        new PersonEntry("Michael", "Brown", "michael.brown@example.com")
                );

        TableColumn<PersonEntry, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<PersonEntry, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<PersonEntry, Integer> phoneColumn = new TableColumn<>("Phone Number");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<PersonEntry, String> firstEmail = new TableColumn<>("Primary");
        firstEmail.setCellValueFactory(new PropertyValueFactory<>("primary email"));

        TableColumn<PersonEntry, String> secondEmail = new TableColumn<>("Secondary");
        secondEmail.setCellValueFactory(new PropertyValueFactory<>("second email"));

        emailColumn.getColumns().addAll(firstEmail, secondEmail);

        table.getColumns().addAll(nameColumn, phoneColumn, emailColumn);

        table.setEditable(true);
        table.setItems(data);

        Button btnAdd = new Button("Add Contact:");
        Button btnEdit = new Button("Edit Contact");
        Button btnDelete = new Button("Delete Selected Contact");

        TextField tfName = new TextField("");
        tfName.setPromptText("(name)");
        tfName.setPrefWidth(100);

        TextField tfPhoneNumber = new TextField("");
        tfPhoneNumber.setPromptText("(number)");
        tfPhoneNumber.setPrefWidth(100);

        TextField tfEmail = new TextField("");
        tfEmail.setPromptText("(email)");
        tfEmail.setPrefWidth(100);



        GridPane g = new GridPane();
        g.add(table, 0, 0);

        g.add(tfName, 0, 1);
        g.add(tfPhoneNumber, 1, 1);
        g.add(tfEmail, 2, 1);

        g.add(btnAdd, 0, 2);
        g.add(btnDelete, 1, 2);
        g.add(btnEdit, 2,2);

        Scene scene = new Scene(g, 500, 500);
        stage.setTitle("Phone Book Editor");
        stage.setScene(scene);
        stage.show();

        btnAdd.setOnAction(e -> {
            //ContactController.entryEntered(tfName.getText(),tfPhoneNumber.getText(),tfEmail.getText());
        });

    }

}

