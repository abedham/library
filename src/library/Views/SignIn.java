/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author AbdelRahman
 */
public class SignIn extends VBox {

    private final int minWidth = 200;
    private final int minWidthLabels = 115;
    private final int spacing = 15;
    private final int padding = 10;

    private Button btnLogin;

    private Label lbUserName;
    private Label lbPassword;

    private TextField tfUserName;
    private TextField tfPassword;

    public SignIn() {
        initSignInView();
    }

    private void initSignInView() {
        setLbUserName(new Label("User Name"));
        getLbUserName().setMinWidth(minWidthLabels);

        setTfUserName(new TextField());
        getTfUserName().setMinWidth(minWidth);
        getTfUserName().setMaxWidth(minWidth);
        getTfUserName().setPromptText("User Name");

        HBox hboxUserName = new HBox(10, lbUserName, tfUserName);
        setLbPassword(new Label("Password"));
        getLbPassword().setMinWidth(minWidthLabels);

        setTfPassword(new TextField());
        getTfPassword().setMinWidth(minWidth);
        getTfPassword().setMaxWidth(minWidth);
        getTfPassword().setPromptText("Password");

        HBox hboxPassword = new HBox(10, lbPassword, tfPassword);
        setBtnLogin(new Button("Login"));

        hboxPassword.setAlignment(Pos.CENTER);
        hboxUserName.setAlignment(Pos.CENTER);
        btnLogin.setOnAction(e -> {
            checkCredentials();
        });

        setSpacing(spacing);
        getChildren().addAll(hboxUserName, hboxPassword, getBtnLogin());
        setAlignment(Pos.CENTER);
        setPadding(new Insets(padding));
    }

    private void checkCredentials() {

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
        getScene().getWindow().hide();
        stage.show();
    }

    /**
     * @return the btnLogin
     */
    public Button getBtnLogin() {
        return btnLogin;
    }

    /**
     * @param btnLogin the btnLogin to set
     */
    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }

    /**
     * @return the tfUserName
     */
    public TextField getTfUserName() {
        return tfUserName;
    }

    /**
     * @param tfUserName the tfUserName to set
     */
    public void setTfUserName(TextField tfUserName) {
        this.tfUserName = tfUserName;
    }

    /**
     * @return the tfPassword
     */
    public TextField getTfPassword() {
        return tfPassword;
    }

    /**
     * @param tfPassword the tfPassword to set
     */
    public void setTfPassword(TextField tfPassword) {
        this.tfPassword = tfPassword;
    }

    /**
     * @return the User Name
     */
    public String getUserName() {
        return getTfUserName().getText();
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return getTfPassword().getText();
    }

    public Label getLbUserName() {
        return lbUserName;
    }

    public void setLbUserName(Label lbUserName) {
        this.lbUserName = lbUserName;
    }

    public Label getLbPassword() {
        return lbPassword;
    }

    public void setLbPassword(Label lbPassword) {
        this.lbPassword = lbPassword;
    }

}
