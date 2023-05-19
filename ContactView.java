package com.example.mvcfinal_2023;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContactView extends Application {

    private TableView<PersonEntry> tableView;
    private ContactModel contactModel;
    private ContactController contactController;
    Button btnAdd = new Button("Add Contact");
    Button btnEdit = new Button("Edit Contact");
    Button btnDelete = new Button("Delete Selected Contact");
    Button btnSave = new Button("Save Contacts");
    TextField tfFirstName;
    TextField tfLastName;
    TextField tfPhoneNumber;
    TextField tfFirstEmail;
    TextField tfSecondEmail;

    @Override
    public void start(Stage stage) {
        contactModel = new ContactModel();
        tableView = new TableView<PersonEntry>();
        contactController = new ContactController(contactModel, tableView, this);

        contactModel.contacts = contactController.readContactsFromFile();

        TableColumn<PersonEntry, String> fNameColumn = new TableColumn<>("First Name");
        fNameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));

        TableColumn<PersonEntry, String> lNameColumn = new TableColumn<>("Last Name");
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));

        TableColumn<PersonEntry, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<PersonEntry, Long> phoneColumn = new TableColumn<>("Phone Number");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<PersonEntry, String> firstEmail = new TableColumn<>("Primary");
        firstEmail.setCellValueFactory(new PropertyValueFactory<>("priEmail"));

        TableColumn<PersonEntry, String> secondEmail = new TableColumn<>("Secondary");
        secondEmail.setCellValueFactory(new PropertyValueFactory<>("secEmail"));

        emailColumn.getColumns().addAll(firstEmail, secondEmail);

        fNameColumn.setMinWidth(100);
        lNameColumn.setMinWidth(100);
        phoneColumn.setMinWidth(100);
        emailColumn.setMinWidth(250);
        firstEmail.setMinWidth(125);
        secondEmail.setMinWidth(125);

        tableView.getColumns().addAll(fNameColumn, lNameColumn, phoneColumn, emailColumn);

        tableView.setEditable(true);
        tableView.setItems(FXCollections.observableArrayList(contactModel.contacts));

        tfFirstName = new TextField("");
        tfFirstName.setPromptText("First Name");
        tfFirstName.setPrefWidth(100);

        tfLastName = new TextField("");
        tfLastName.setPromptText("Last Name");
        tfLastName.setPrefWidth(100);

        tfPhoneNumber = new TextField("");
        tfPhoneNumber.setPromptText("Phone");
        tfPhoneNumber.setPrefWidth(100);

        tfFirstEmail = new TextField("");
        tfFirstEmail.setPromptText("Primary Email");
        tfFirstEmail.setPrefWidth(100);

        tfSecondEmail = new TextField("");
        tfSecondEmail.setPromptText("Second Email");
        tfSecondEmail.setPrefWidth(100);

        BorderPane border = new BorderPane();
        border.setPadding(new javafx.geometry.Insets(10));
        VBox tableBox = new VBox();
        HBox textBoxes = new HBox();
        HBox buttonBox = new HBox();
        VBox optionsBox = new VBox();

        tableBox.getChildren().addAll(tableView);

        contactController.setupButtonHandlers();

        textBoxes.setSpacing(10);
        textBoxes.setAlignment(Pos.CENTER);
        textBoxes.getChildren().addAll(tfFirstName, tfLastName, tfPhoneNumber, tfFirstEmail, tfSecondEmail);

        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(btnAdd, btnEdit, btnDelete, btnSave);

        optionsBox.setSpacing(10);
        optionsBox.getChildren().addAll(textBoxes, buttonBox);

        border.setCenter(tableBox);
        border.setBottom(optionsBox);

        Scene scene = new Scene(border, 550, 500);
        stage.setTitle("Phone Book Editor");
        stage.setScene(scene);
        stage.show();
    }

    public Button getBtnAdd() {
        return btnAdd;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public Button getBtnSave() {
        return btnSave;
    }
}
