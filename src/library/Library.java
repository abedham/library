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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.LEFT);

        Tab tab = new Tab();
        Tab tab2 = new Tab();
        Tab tab3 = new Tab();
        Tab tab4 = new Tab();
        Tab tab5 = new Tab();
        Tab tab6 = new Tab();

        tab.closableProperty().set(false);
        tab2.closableProperty().set(false);
        tab3.closableProperty().set(false);
        tab4.closableProperty().set(false);
        tab5.closableProperty().set(false);
        tab6.closableProperty().set(false);

        tab.setContent(addMember);
        tab2.setContent(addPublisher);
        tab3.setContent(addBook);
        tab4.setContent(addSection);
        tab5.setContent(addEmployee);
        tab6.setContent(memberData);

        tab.setText("Add Member");
        tab2.setText("Add Publisher");
        tab3.setText("Add Book");
        tab4.setText("Add Section");
        tab5.setText("Add Employee");
        tab6.setText("Member Data");

        tabPane.getTabs().addAll(tab, tab2, tab3, tab4, tab5, tab6);

        GridPane gridPane = new GridPane();
        gridPane.addColumn(0, addMember, signIn, addPublisher);
        gridPane.addColumn(1, addSection, addEmployee);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10));

        Scene scene = new Scene(tabPane, 800, 600);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox getSignInView() {

        TextField tfUserName = new TextField();
        tfUserName.setMinWidth(minWidth);
        tfUserName.setMaxWidth(minWidth);
        tfUserName.setPromptText("User Name");

        TextField tfPassword = new TextField();
        tfPassword.setMinWidth(minWidth);
        tfPassword.setMaxWidth(minWidth);
        tfPassword.setPromptText("Password");

        Button btnLogin = new Button("Login");
        VBox vbox = new VBox(15, tfUserName, tfPassword, btnLogin);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox getAddBookView() {

        Label lbBookName = new Label("Book Name");
        lbBookName.setMinWidth(minWidthLabels);

        TextField tfBookName = new TextField();
        tfBookName.setMinWidth(minWidth);
        tfBookName.setPromptText("Book Name");

        HBox hboxBookName = new HBox(10, lbBookName, tfBookName);

        Label lbSection = new Label("Section");
        lbSection.setMinWidth(minWidthLabels);

        ComboBox<String> cbSection = new ComboBox<>();
        cbSection.setMinWidth(minWidth);

        HBox hboxSection = new HBox(10, lbSection, cbSection);

        Label lbPublisher = new Label("Publisher");
        lbPublisher.setMinWidth(minWidthLabels);

        ComboBox<String> cbPublisher = new ComboBox<>();
        cbPublisher.setMinWidth(minWidth);

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

        Button btnAddBook = new Button("+");

        VBox vbox = new VBox(15, hboxBookName, hboxSection, hboxPublisher, lvAuthor, btnAddBook);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox getAddMemberView() {
        Label lbMemberName = new Label("Member Name");
        lbMemberName.setMinWidth(minWidthLabels);

        TextField tfMemberName = new TextField();
        tfMemberName.setMinWidth(minWidth);
        tfMemberName.setPromptText("Member Name");

        HBox hboxMemberName = new HBox(10, lbMemberName, tfMemberName);

        Label lbMemberAddress = new Label("Member Address");
        lbMemberAddress.setMinWidth(minWidthLabels);

        TextField tfMemberAddress = new TextField();
        tfMemberAddress.setMinWidth(minWidth);
        tfMemberAddress.setPromptText("Member Address");

        HBox hboxMemberAddress = new HBox(10, lbMemberAddress, tfMemberAddress);

        Label lbExpireDate = new Label("Expire Date");
        lbExpireDate.setMinWidth(minWidthLabels);
        DatePicker dpExpireDate = new DatePicker(LocalDate.now());
        dpExpireDate.setMinWidth(minWidth);

        HBox hboxExpireDate = new HBox(10, lbExpireDate, dpExpireDate);

        Label lbPhoneNumber = new Label("Phone Number");
        lbPhoneNumber.setMinWidth(minWidthLabels);

        TextField tfPhoneNumber = new TextField();
        tfPhoneNumber.setMinWidth(minWidth);
        tfPhoneNumber.setPromptText("Phone Number");

        HBox hboxPhoneNumber = new HBox(10, lbPhoneNumber, tfPhoneNumber);

        Button btnAddMember = new Button("+");

        VBox vbox = new VBox(15, hboxMemberName, hboxMemberAddress,
                hboxPhoneNumber, hboxExpireDate, btnAddMember);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox getAddSectionView() {
        Label lbSectionName = new Label("Section Name");
        lbSectionName.setMinWidth(minWidthLabels);

        TextField tfSectionName = new TextField("Section Name");
        tfSectionName.setMinWidth(minWidth);

        HBox hboxSectionName = new HBox(10, lbSectionName, tfSectionName);

        Button btnAddSection = new Button("+");
        VBox vbox = new VBox(15, hboxSectionName, btnAddSection);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox getAddEmployeeView() {
        Label lbEmployeeName = new Label("Employee Name");
        lbEmployeeName.setMinWidth(minWidthLabels);

        TextField tfEmployeeName = new TextField();
        tfEmployeeName.setMinWidth(minWidth);
        tfEmployeeName.setPromptText("Employee Name");
        HBox hboxEmployeeName = new HBox(10, lbEmployeeName, tfEmployeeName);

        Label lbEmployeeAddress = new Label("Employee Address");
        lbEmployeeAddress.setMinWidth(minWidthLabels);

        TextField tfEmployeeAddress = new TextField();
        tfEmployeeAddress.setMinWidth(minWidth);
        tfEmployeeAddress.setPromptText("Employee Address");
        HBox hboxEmployeeAddress = new HBox(10, lbEmployeeAddress, tfEmployeeAddress);

        Label lbSalary = new Label("Salary");
        lbSalary.setMinWidth(minWidthLabels);
        TextField tfSalary = new TextField();
        tfSalary.setMinWidth(minWidth);
        HBox hboxSalary = new HBox(10, lbSalary, tfSalary);
        Button btnAddEmployee = new Button("+");

        CheckBox chIsAdmin = new CheckBox("Admin Privileges");
        VBox vbox = new VBox(15, hboxEmployeeName, hboxEmployeeAddress,
                hboxSalary, chIsAdmin, btnAddEmployee);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox getAddPublisherView() {
        Label lbPublisherName = new Label("Publisher Name");
        lbPublisherName.setMinWidth(minWidthLabels);

        TextField tfPublisherName = new TextField();
        tfPublisherName.setMinWidth(minWidth);
        tfPublisherName.setPromptText("Publisher Name");
        HBox hboxPublisherName = new HBox(10, lbPublisherName, tfPublisherName);

        Label lbPublisherAddress = new Label("Publisher Address");
        lbPublisherAddress.setMinWidth(minWidthLabels);

        TextField tfPublisherAddress = new TextField();
        tfPublisherAddress.setMinWidth(minWidth);
        tfPublisherAddress.setPromptText("Publisher Address");
        HBox hboxPublisherAddress = new HBox(10, lbPublisherAddress, tfPublisherAddress);

        Button btnAddPublisher = new Button("+");
        VBox vbox = new VBox(15, hboxPublisherName, hboxPublisherAddress, btnAddPublisher);
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
