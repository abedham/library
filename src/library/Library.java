/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and  open the template in the editor.
 */
package library;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import library.AllClass.Employee;
import library.Views.AddBook;
import library.Views.AddEmployee;
import library.Views.AddMember;
import library.Views.AddPublisher;
import library.Views.AddSection;
import library.Views.MemberData;
import library.Views.SignIn;
import library.show.show_data;
import library.show_tables.show_employee_table;

/**
 *
 * @author abdelrahman
 */
public class Library extends Application {

    Employee currentEmployee;
    add addition = new add();

    @Override
    public void start(Stage primaryStage) throws SQLException {
        show_employee_table shEmpTv = new show_employee_table();
        show_data shData = new show_data();

        SignIn signIn = new SignIn();
        AddMember addMember = new AddMember();
        AddPublisher addPublisher = new AddPublisher();
        AddBook addBook = new AddBook();
        AddSection addSection = new AddSection();

        AddEmployee addEmployee = new AddEmployee();
        addEmployee.setTvEmployees(shEmpTv.getTable_emp(shData.emp_show()));
        addEmployee.getBtnAddEmployee().setOnAction(e -> {
            try {
                int salary = Integer.parseInt(addEmployee.getSalary());
                Employee emp = addition.add_employee(addEmployee.getEmployeeName(), addEmployee.getEmployeeAddress(),
                        addEmployee.isAdmin(), addEmployee.getEmail(), salary);
                if (emp != null) {
                    addEmployee.getTvEmployees().getItems().add(emp);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error salary");
            }
        });

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
            int id = signIn.getUserId();
            String pass = signIn.getPassword();
            currentEmployee = Model.logIn(id, pass);
            Stage stage = new Stage();

            if (currentEmployee != null) {
                if (currentEmployee.isAdmin()) {             /// if was an admin
                    tabPane.getTabs().addAll(tabAddMember, tabAddBook,
                            tabAddEmployee, tabMemberData);
                    stage.setTitle("Control Panel(Admin)");

                } else {              /// if was an employee
                    tabPane.getTabs().addAll(tabAddMember, tabAddBook, tabMemberData);
                    stage.setTitle("Control Panel");
                }
                Scene scene = new Scene(tabPane);

                stage.setScene(scene);
                primaryStage.hide();
                stage.show();
            } else {             /// if wrong input
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning !");
                alert.setHeaderText("Wrong credentials");
                alert.setContentText("Please check username and password");

                alert.showAndWait();
            }
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
