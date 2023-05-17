package com.example.mvcfinal_2023;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;


       public class ContactView extends Application{
            @Override
            public void start(Stage stage) throws IOException {

                BorderPane p = new BorderPane();
                Scene scene = new Scene(p, 500, 500);

                //PersonEntry p1 = new PersonEntry("Steve","5555555555", "Steve");
                TableView table = new TableView();
                TableColumn name = new TableColumn("Name");
                TableColumn phoneNumber = new TableColumn("Phone Number");
                TableColumn email = new TableColumn("Email");

                table.getColumns().addAll(name, phoneNumber, email);



                Button btnAdd = new Button("Add:");
                Button btnDelete = new Button("Delete Selected Entry");

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
                g.add(btnAdd, 0, 0);
                g.add(tfName, 1, 0);
                g.add(tfPhoneNumber, 2, 0);
                g.add(tfEmail, 3, 0);
                g.add(btnDelete, 0, 1);


                p.setCenter(table);
                p.setBottom(g);


                stage.setTitle("Phone Book Editor");
                stage.setScene(scene);
                stage.show();


                btnAdd.setOnAction(e -> {
                    //ContactController.entryEntered(tfName.getText(),tfPhoneNumber.getText(),tfEmail.getText());
                });

            }


    }


