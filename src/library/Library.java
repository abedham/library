/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.Observable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author abdelrahman
 */
public class Library extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(getAddSectionView(), 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox getSignInView() {

        TextField tfUserName = new TextField();
        tfUserName.setPromptText("User Name");

        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Password");

        Button btnLogin = new Button("Login");
        VBox vbox = new VBox(15, tfUserName, tfPassword, btnLogin);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox getAddBookView() {

        Label lbBookName = new Label("Book Name");
        TextField tfBookName = new TextField();
        tfBookName.setPromptText("Book Name");
        HBox hboxBookName = new HBox(10, lbBookName, tfBookName);

        Label lbSection = new Label("Section");
        ComboBox<String> cbSection = new ComboBox<>();
        HBox hboxSection = new HBox(10, lbSection, cbSection);

        Label lbPublisher = new Label("Publisher");
        ComboBox<String> cbPublisher = new ComboBox<>();
        HBox hboxPublisher = new HBox(10, lbPublisher, cbPublisher);

        ListView lvAuthor = new ListView();
        lvAuthor.setItems(FXCollections.observableArrayList());
        Button btnAddAuthor = new Button("+");
        lvAuthor.getItems().add(new HBox(5, new TextField("Author Name 1"), btnAddAuthor));
        btnAddAuthor.setOnAction(e -> {
            int size = lvAuthor.getItems().size();
            HBox hbox = ((HBox) lvAuthor.getItems().get(size - 1));
            hbox.getChildren().remove(btnAddAuthor);
            lvAuthor.getItems().add(new HBox(5, new TextField("Author Name 1"), btnAddAuthor));
        });

        VBox vbox = new VBox(15, hboxBookName, hboxSection, hboxPublisher, lvAuthor);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox getAddMemberView() {
        Label lbMemberName = new Label("Member Name");
        TextField tfMemberName = new TextField();
        tfMemberName.setPromptText("Member Name");
        HBox hboxMemberName = new HBox(10, lbMemberName, tfMemberName);

        Label lbMemberAddress = new Label("Member Address");
        TextField tfMemberAddress = new TextField();
        tfMemberAddress.setPromptText("Member Address");
        HBox hboxMemberAddress = new HBox(10, lbMemberAddress, tfMemberAddress);

        Label lbExpireDate = new Label("Expire Date");
        DatePicker dpExpireDate = new DatePicker(LocalDate.now());
        HBox hboxExpireDate = new HBox(10, lbExpireDate, dpExpireDate);

        Label lbPhoneNumber = new Label("Phone Number");
        TextField tfPhoneNumber = new TextField();
        tfPhoneNumber.setPromptText("Phone Number");
        HBox hboxPhoneNumber = new HBox(10, lbPhoneNumber, tfPhoneNumber);

        VBox vbox = new VBox(15, hboxMemberName, hboxMemberAddress, hboxPhoneNumber, hboxExpireDate);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }
    
    private VBox getAddEmployeeView() {
        Label lbEmployeeName = new Label("Employee Name");
        TextField tfEmployeeName = new TextField();
        tfEmployeeName.setPromptText("Employee Name");
        HBox hboxEmployeeName = new HBox(10, lbEmployeeName, tfEmployeeName);

        Label lbEmployeeAddress = new Label("Employee Address");
        TextField tfEmployeeAddress = new TextField();
        tfEmployeeAddress.setPromptText("Employee Address");
        HBox hboxEmployeeAddress = new HBox(10, lbEmployeeAddress, tfEmployeeAddress);

        Label lbSalary = new Label("Salary");
        TextField tfSalary = new TextField();
        HBox hboxSalary = new HBox(10, lbSalary, tfSalary);

        VBox vbox = new VBox(15, hboxEmployeeName, hboxEmployeeAddress, hboxSalary);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox getAddPublisherView() {
        Label lbPublisherName = new Label("Publisher Name");
        TextField tfPublisherName = new TextField();
        tfPublisherName.setPromptText("Publisher Name");
        HBox hboxPublisherName = new HBox(10, lbPublisherName, tfPublisherName);

        Label lbPublisherAddress = new Label("Publisher Address");
        TextField tfPublisherAddress = new TextField();
        tfPublisherAddress.setPromptText("Publisher Address");
        HBox hboxPublisherAddress = new HBox(10, lbPublisherAddress, tfPublisherAddress);

        
        VBox vbox = new VBox(15, hboxPublisherName, hboxPublisherAddress);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox getAddSectionView() {
        Label lbSectionName = new Label("Section Name");
        TextField tfSectionName = new TextField();
        tfSectionName.setPromptText("Section Name");
        HBox hboxSectionName = new HBox(10, lbSectionName, tfSectionName);

        
        VBox vbox = new VBox(15, hboxSectionName);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
