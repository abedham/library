/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and  open the template in the editor.
 */
package library;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import library.AllClass.EmpBook;
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
import library.Views.BooksData;
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
    BooksData booksData = new BooksData();

    TabPane tabPane = new TabPane();

    Tab tabAddMember = new Tab();
//        Tab tabAddPublisher = new Tab();
    Tab tabAddBook = new Tab();
//        Tab tabAddSection = new Tab();
    Tab tabAddEmployee = new Tab();
    Tab tabMemberData = new Tab();
//    Tab tabBooksData = new Tab();

    @Override
    public void start(Stage primaryStage) {

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
                currentEmployee = Model.logIn(58, "123456");

            } catch (Exception ex) {

            }
            if (currentEmployee != null) {

                initAddBook();
                initAddMember();
                initAddEmployee();
                initAddPublisher();
                initAddSection();
                initMemberData();
                initTabPane();
                initBooksData();

                tabPane.getTabs().clear();
                tabPane.getTabs().addAll(tabAddMember, tabAddBook, tabMemberData);//, tabBooksData);
                booksData.setAdmin(currentEmployee.isAdmin());

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

            if (addBook.getBookName().isEmpty()) {
                CustomAlertMsg.getEmptyError("Book Name");
            } else if (addBook.getPublisher() == null) {
                CustomAlertMsg.getEmptyError("Publisher Name");
            } else if (addBook.getSection() == null) {
                CustomAlertMsg.getEmptyError("Section Type");
            } else if (addBook.getAuthors().isEmpty()) {
                CustomAlertMsg.getEmptyError("Authers");
            } else {
                book book = add.add_Book(addBook.getBookName(), true, addBook.getSection().getSec_id(),
                        addBook.getPublisher().getId(), addBook.getAuthors(), currentEmployee.getEmp_id());

                EmpBook empBook = new EmpBook(book.getBook_id(),
                        book.getTitle(), addBook.getSection().getSec_name(),
                        addBook.getPublisher().getName(), currentEmployee.getEmp_name(),
                        Model.formatDate(new Date()), true);
                DataSingleton.getInstance().getEmpBooks().add(empBook);
            }
        });
    }

    private void initAddPublisher() {
        addPublisher.getBtnAddPublisher().setOnAction(e -> {
            if (CustomAlertMsg.checkNameError(addPublisher.getPublisherName())
                    || CustomAlertMsg.checkAddress(addPublisher.getPublisherAddress())) {
            } else {
                Publisher pub = add.add_Publisher(addPublisher.getPublisherName(),
                        addPublisher.getPublisherAddress());
                addBook.getCbPublisher().getItems().add(pub);
            }

        }
        );
    }

    private void initAddSection() {
        addSection.getBtnAddSection().setOnAction(e -> {
            if (!CustomAlertMsg.checkNameError(addSection.getSectionName())) {
                Section sec = add.add_section(addSection.getSectionName());
                addBook.getCbSection().getItems().add(sec);
            }
        });
    }

    private void initAddMember() {
        addMember.getBtnAddMember().setOnAction(e -> {
            if (CustomAlertMsg.checkNameError(addMember.getMemberName())) {
            } else if (CustomAlertMsg.checkAddress(addMember.getMemberAddress())) {
            } else if (CustomAlertMsg.checkEmail(addMember.getMemberEmail())) {
            } else if (addMember.getPhoneNumbers().isEmpty()) {
                CustomAlertMsg.getEmptyError("Phone Number");
            } else if (addMember.getExpireDate().isBefore(LocalDate.now())) {
                CustomAlertMsg.getDateError("before");
            } else {
                member add_Member = add.add_Member(addMember.getMemberName(), addMember.getMemberEmail(),
                        addMember.getPhoneNumbers(), currentEmployee.getEmp_id(),
                        addMember.getMemberAddress(), addMember.getExpireDate().toString());
            }
        });
    }

    private void initMemberData() {

        memberData.getTfMemberID().setOnAction(e -> {
            try {
                member member = Model.getMember(memberData.getMemberId());
                List<String> phones = Model.getMemberPhones(memberData.getMemberId());
                if (member != null) {
                    memberData.setMemberName(member.getName());
                    memberData.setEmail(member.getEmail());
                    memberData.setExpireDate(member.getExpire_date());
                    memberData.setMemberAddress(member.getAddress());
                    if (phones != null && phones.size() > 0) {
                        memberData.setPhoneNumber(phones.get(0));
                    } else {
                        memberData.setPhoneNumber("");
                    }
                    List<MemberBook> empBooks = Model.getMemberBooks(member.getMem_id());
                    memberData.setData(FXCollections.observableList(empBooks));
                } else {
                    memberData.getData().clear();
                    CustomAlertMsg.getDoesNotExist("Member");
                }
            } catch (NumberFormatException ex) {
                CustomAlertMsg.getIDError();
            }
        });
        memberData.getBtnBorrow().setOnAction(e -> {

            try {
                EmpBook empBook = booksData.getEmpBook(memberData.getBookId());
                if (empBook.isAvailable()) {
//                if (memberData.getDate().compareTo(LocalDate.ofEpochDay(new Date().getTime())) > 0) {
                    int borrowId = Model.borrowBook(memberData.getBookId(), memberData.getMemberId(), currentEmployee.getEmp_id(), memberData.getDate());
                    MemberBook memberBook = new MemberBook(memberData.getBookId(),
                            borrowId, memberData.getMemberId(), empBook.getBookName(),
                            Model.formatDate(new Date()), Model.formatDate(memberData.getDate()), false);
                    DataSingleton.getInstance().getMemberBooks().add(memberBook);
                    empBook.setAvailable(false);
//                } else {
//                    //Expire date error
//                }
                }
            } catch (NumberFormatException ex) {
                // Ammar add id errors,
            }
        });
    }

    private void initBooksData() {

        booksData.getTableView().getItems().clear();
        booksData.setData(Model.getBooks());

    }

    private void initAddEmployee() {
        show_employee_table shEmpTv = new show_employee_table();
        DataSingleton data = DataSingleton.getInstance();
        data.setEmployess(shData.emp_show());
        addEmployee.setTvEmployees(shEmpTv.getTable_emp(data.getEmployess()));
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
                data.getEmployess().add(emp);
            }

        }
        );
    }

    private void initTabPane() {

        tabPane.setSide(Side.TOP);

        tabAddMember.closableProperty().set(false);
//        tabAddPublisher.closableProperty().set(false);
        tabAddBook.closableProperty().set(false);
//        tabAddSection.closableProperty().set(false);
        tabAddEmployee.closableProperty().set(false);
        tabMemberData.closableProperty().set(false);
//        tabBooksData.closableProperty().set(false);

        tabAddMember.setContent(addMember);
//        tabAddPublisher.setContent(addPublisher);

        VBox vboxPubSec = new VBox(10, addPublisher, addSection);
        vboxPubSec.setAlignment(Pos.CENTER);
        vboxPubSec.setPadding(new Insets(10));

        HBox hboxBook = new HBox(10, addBook, vboxPubSec, booksData);
        hboxBook.setAlignment(Pos.CENTER);
        hboxBook.setPadding(new Insets(10));

        tabAddBook.setContent(hboxBook);
//        tabAddSection.setContent(addSection);
        tabAddEmployee.setContent(addEmployee);
        tabMemberData.setContent(memberData);
//        tabBooksData.setContent(booksData);
        tabAddMember.setText("Add Member");
//        tabAddPublisher.setText("Add Publisher");
        tabAddBook.setText("Add Book");
//        tabAddSection.setText("Add Section");
        tabAddEmployee.setText("Add Employee");
        tabMemberData.setText("Member Data");
//        tabBooksData.setText("Books Data");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
