/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and  open the template in the editor.
 */
package library;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import library.Views.AddBook;
import library.Views.AddEmployee;
import library.Views.AddMember;
import library.Views.AddPublisher;
import library.Views.AddSection;
import library.Views.MemberData;
import library.Views.SignIn;

/**
 *
 * @author abdelrahman
 */
public class Library extends Application {

    private int minWidth = 200;
    private int minWidthLabels = 115;

    @Override
    public void start(Stage primaryStage) {

        SignIn signIn = new SignIn();
        AddMember addMember = new AddMember();
        AddPublisher addPublisher = new AddPublisher();
        AddBook addBook = new AddBook();
        AddSection addSection = new AddSection();
        AddEmployee addEmployee = new AddEmployee();
        MemberData memberData = new MemberData();

        VBox vboxPubSec = new VBox(10, addPublisher, addSection);
        vboxPubSec.setAlignment(Pos.CENTER);
        vboxPubSec.setPadding(new Insets(10));

        HBox hboxBook = new HBox(10, addBook, vboxPubSec);
        hboxBook.setAlignment(Pos.CENTER);
        hboxBook.setPadding(new Insets(10));

        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.TOP);

        Tab tabAddMember = new Tab();
//        Tab tabAddPublisher = new Tab();
        Tab tabAddBook = new Tab();
//        Tab tabAddSection = new Tab();
        Tab tabAddEmployee = new Tab();
        Tab tabMemberData = new Tab();

        tabAddMember.closableProperty().set(false);
//        tabAddPublisher.closableProperty().set(false);
        tabAddBook.closableProperty().set(false);
//        tabAddSection.closableProperty().set(false);
        tabAddEmployee.closableProperty().set(false);
        tabMemberData.closableProperty().set(false);

        tabAddMember.setContent(addMember);
//        tabAddPublisher.setContent(addPublisher);
        tabAddBook.setContent(hboxBook);
//        tabAddSection.setContent(addSection);
        tabAddEmployee.setContent(addEmployee);
        tabMemberData.setContent(memberData);

        tabAddMember.setText("Add Member");
//        tabAddPublisher.setText("Add Publisher");
        tabAddBook.setText("Add Book");
//        tabAddSection.setText("Add Section");
        tabAddEmployee.setText("Add Employee");
        tabMemberData.setText("Member Data");

        signIn.getBtnLogin().setOnAction(e -> {
            if (true) {             /// if was an admin
                tabPane.getTabs().addAll(tabAddMember, tabAddBook,
                        tabAddEmployee, tabMemberData);

            } else if (false) {              /// if was an employee
                tabPane.getTabs().addAll(tabAddMember, tabAddBook, tabMemberData);

            } else {             /// if wrong input
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning !");
                alert.setHeaderText("Wrong credentials");
                alert.setContentText("Please check username and password");

                alert.showAndWait();
            }
            Scene scene = new Scene(tabPane);
            Stage stage = new Stage();
            stage.setTitle("Control Panel");
            stage.setScene(scene);
            primaryStage.hide();
            stage.show();
        });
        Scene scene = new Scene(signIn);

        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
