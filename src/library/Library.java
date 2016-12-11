/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and  open the template in the editor.
 */
package library;

import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
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
import library.AllClass.MemberBook;
import library.AllClass.Employee;
import library.AllClass.Publisher;
import library.AllClass.Section;
import library.AllClass.book;
import library.AllClass.member;
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

    public static Employee currentEmployee;
    add addition = new add();
    show_data shData = new show_data();

    SignIn signIn = new SignIn();

    AddBook addBook = new AddBook();
    AddMember addMember = new AddMember();
    AddPublisher addPublisher = new AddPublisher();
    AddSection addSection = new AddSection();

    AddEmployee addEmployee = new AddEmployee();

    MemberData memberData = new MemberData();

    TabPane tabPane = new TabPane();

    Tab tabAddMember = new Tab();
//        Tab tabAddPublisher = new Tab();
    Tab tabAddBook = new Tab();
//        Tab tabAddSection = new Tab();
    Tab tabAddEmployee = new Tab();
    Tab tabMemberData = new Tab();

    @Override
    public void start(Stage primaryStage) {
        initAddBook();
        initAddMember();
        initAddEmployee();
        initAddPublisher();
        initAddSection();
        initMemberData();
        initTabPane();
        initSignIn(primaryStage);

        Scene scene = new Scene(signIn);
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initSignIn(Stage primaryStage) {

        signIn.getBtnLogin().setOnAction(e -> {
            try {
                int id = signIn.getUserId();
                String pass = signIn.getPassword();
//                currentEmployee = Model.logIn(id, pass);
                currentEmployee = Model.logIn(26, "123456789");
                tabPane.getTabs().clear();
                tabPane.getTabs().addAll(tabAddMember, tabAddBook, tabMemberData);
            } catch (Exception ex) {

            }
            if (currentEmployee != null) {
                if (currentEmployee.isAdmin()) {             /// if was an admin
                    tabPane.getTabs().add(tabAddEmployee);
                    primaryStage.setTitle("Control Panel (Admin)");
                } else {              /// if was an employee                    
                    primaryStage.setTitle("Control Panel");
                }
                Scene scene = new Scene(tabPane);
                primaryStage.hide();
                primaryStage.setScene(scene);
                primaryStage.show();
//                primaryStage.setWidth(800);
//                primaryStage.setHeight(700);
                primaryStage.setMaximized(true);
            } else {             /// if wrong input
                CustomAlertMsg.getLoginError();
            }
        });
    }

    private void initAddBook() {
        addBook.setPublishers(shData.publisher_show());
        addBook.setSections(shData.Section_show());
        addBook.getBtnAddBook().setOnAction(e -> {
            book book = add.add_Book(addBook.getBookName(), true, addBook.getSection().getSec_id(),
                    addBook.getPublisher().getId(), addBook.getAuthors(), currentEmployee.getEmp_id());
        });
    }

    private void initAddPublisher() {
        addPublisher.getBtnAddPublisher().setOnAction(e -> {
            Publisher pub = add.add_Publisher(addPublisher.getPublisherName(), addPublisher.getPublisherAddress());
            addBook.getCbPublisher().getItems().add(pub);
        });
    }

    private void initAddSection() {
        addSection.getBtnAddSection().setOnAction(e -> {
            Section sec = add.add_section(addSection.getSectionName());
            addBook.getCbSection().getItems().add(sec);
        });
    }

    private void initTabPane() {

        tabPane.setSide(Side.TOP);

        tabAddMember.closableProperty().set(false);
//        tabAddPublisher.closableProperty().set(false);
        tabAddBook.closableProperty().set(false);
//        tabAddSection.closableProperty().set(false);
        tabAddEmployee.closableProperty().set(false);
        tabMemberData.closableProperty().set(false);

        tabAddMember.setContent(addMember);
//        tabAddPublisher.setContent(addPublisher);

        VBox vboxPubSec = new VBox(10, addPublisher, addSection);
        vboxPubSec.setAlignment(Pos.CENTER);
        vboxPubSec.setPadding(new Insets(10));

        HBox hboxBook = new HBox(10, addBook, vboxPubSec);
        hboxBook.setAlignment(Pos.CENTER);
        hboxBook.setPadding(new Insets(10));

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

    }

    private void initAddMember() {
        addMember.getBtnAddMember().setOnAction(e -> {
            member add_Member = add.add_Member(addMember.getMemberName(), addMember.getMemberEmail(),
                    addMember.getPhoneNumbers(), currentEmployee.getEmp_id(),
                    addMember.getMemberAddress(), addMember.getExpireDate().toString());
        });
    }

    private void initMemberData() {

        memberData.getTfMemberID().setOnAction(e -> {

            member member = Model.getMember(memberData.getMemberId());
            List<String> phones = Model.getMemberPhones(memberData.getMemberId());
            if (member != null) {
                memberData.setMemberName(member.getName());
                memberData.setEmail(member.getEmail());
                memberData.setExpireDate(member.getExpire_date());
                memberData.setMemberAddress(member.getAddress());
                memberData.setPhoneNumber(phones.get(0));
                List<MemberBook> empBooks = Model.getEmpBooks(member.getMem_id());
                memberData.getTableView().setItems(FXCollections.observableList(empBooks));
            }
        });
    }

    private void initAddEmployee() {
        show_employee_table shEmpTv = new show_employee_table();
        addEmployee.setTvEmployees(shEmpTv.getTable_emp(shData.emp_show()));
        addEmployee.getBtnAddEmployee().setOnAction(e -> {

            if (CustomAlertMsg.checkNameError(addEmployee.getEmployeeName())) {
                return;
            } else if (addEmployee.getEmployeeAddress().isEmpty()) {
                CustomAlertMsg.getEmptyError("Address");
                return;
            } else if (CustomAlertMsg.checkSalary(addEmployee.getSalary())) {
                return;
            } else if (CustomAlertMsg.checkEmail(addEmployee.getEmail())) {
                return;
            } else if (CustomAlertMsg.checkPass(addEmployee.getPassword())) {
                return;
            }
            int salary = Integer.parseInt(addEmployee.getSalary());
            Employee emp = addition.add_employee(addEmployee.getEmployeeName(), addEmployee.getEmployeeAddress(),
                    addEmployee.isAdmin(), addEmployee.getEmail(), salary, addEmployee.getPassword());
            if (emp != null) {
                addEmployee.getTvEmployees().getItems().add(emp);
            }

        }
        );
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
