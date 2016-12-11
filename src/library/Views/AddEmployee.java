/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Itach
 */
public class AddEmployee extends VBox {

    private final int minWidth = 200;
    private final int minWidthLabels = 200;
    private final int spacing = 15;
    private final int padding = 10;

    private Label lbEmployeeName = new Label("Employee Name");
    private Label lbEmployeeAddress = new Label("Employee Address");
    private Label lbSalary = new Label("Salary");
    private Label lbEmail = new Label("Email");
    private Label lbPassword = new Label("Password");
    
    private TextField tfEmployeeName = new TextField();
    private TextField tfEmployeeAddress = new TextField();
    private TextField tfSalary = new TextField();
    private TextField tfEmail = new TextField();
    private TextField tfPassword = new TextField();

    private Button btnAddEmployee = new Button("+");

    private CheckBox chIsAdmin = new CheckBox("Admin Privileges");

    TableView tvEmployees = new TableView();

    public AddEmployee() {
        initAddEmployeeView();
    }

    private void initAddEmployeeView() {
        lbEmail.setMinWidth(minWidthLabels);

        tfEmail.setPromptText("Email");
        tfEmail.setMinWidth(minWidth);
        HBox hboxEmail = new HBox(10, lbEmail, tfEmail);

        lbEmployeeName.setMinWidth(minWidthLabels);

        tfEmployeeName.setMinWidth(minWidth);
        tfEmployeeName.setPromptText("Employee Name");
        HBox hboxEmployeeName = new HBox(10, lbEmployeeName, tfEmployeeName);

        lbEmployeeAddress.setMinWidth(minWidthLabels);

        tfEmployeeAddress.setMinWidth(minWidth);
        tfEmployeeAddress.setPromptText("Employee Address");
        HBox hboxEmployeeAddress = new HBox(10, lbEmployeeAddress, tfEmployeeAddress);

        lbSalary.setMinWidth(minWidthLabels);
        tfSalary.setMinWidth(minWidth);
        tfSalary.setPromptText("Salary");
        HBox hboxSalary = new HBox(10, lbSalary, tfSalary);

        lbPassword.setMinWidth(minWidthLabels);
        tfPassword.setMinWidth(minWidth);
        tfPassword.setPromptText("Password");
        HBox hboxPassword = new HBox(10, lbPassword, tfPassword);

        hboxEmail.setAlignment(Pos.CENTER);
        hboxPassword.setAlignment(Pos.CENTER);
        hboxSalary.setAlignment(Pos.CENTER);
        hboxEmployeeName.setAlignment(Pos.CENTER);
        hboxEmployeeAddress.setAlignment(Pos.CENTER);

        double tableWidth = 1.3 * (minWidth + minWidthLabels);
        tvEmployees.setMaxWidth(tableWidth);

        setSpacing(spacing);
        getChildren().addAll(hboxEmployeeName, hboxEmployeeAddress,
                hboxSalary, hboxEmail, hboxPassword, chIsAdmin, btnAddEmployee);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(padding));

    }

    public String getLbEmployeeName() {
        return lbEmployeeName.getText();
    }

    public void setLbEmployeeName(Label lbEmployeeName) {
        this.lbEmployeeName = lbEmployeeName;
    }

    public String getLbEmployeeAddress() {
        return lbEmployeeAddress.getText();
    }

    public void setLbEmployeeAddress(Label lbEmployeeAddress) {
        this.lbEmployeeAddress = lbEmployeeAddress;
    }

    public String getLbSalary() {
        return lbSalary.getText();
    }

    public void setLbSalary(Label lbSalary) {
        this.lbSalary = lbSalary;
    }

    public String getTfEmployeeAddress() {
        return tfEmployeeAddress.getText();
    }

    public void setTfEmployeeAddress(TextField tfEmployeeAddress) {
        this.tfEmployeeAddress = tfEmployeeAddress;
    }

    public String getTfEmployeeName() {
        return tfEmployeeName.getText();
    }

    public void setTfEmployeeName(TextField tfEmployeeName) {
        this.tfEmployeeName = tfEmployeeName;
    }

    public String getTfSalary() {
        return tfSalary.getText();
    }

    public void setTfSalary(TextField tfSalary) {
        this.tfSalary = tfSalary;
    }

    public String getSalary() {
        return tfSalary.getText();
    }

    public Button getBtnAddEmployee() {
        return btnAddEmployee;
    }

    public void setBtnAddEmployee(Button btnAddEmployee) {
        this.btnAddEmployee = btnAddEmployee;
    }

    public CheckBox getChIsAdmin() {
        return chIsAdmin;
    }

    public void setChIsAdmin(CheckBox chIsAdmin) {
        this.chIsAdmin = chIsAdmin;
    }

    public String getEmployeeName() {
        return tfEmployeeName.getText();
    }

    public String getEmployeeAddress() {
        return tfEmployeeAddress.getText();
    }

    public TableView getTvEmployees() {
        return tvEmployees;
    }

    public void setTvEmployees(TableView tvEmployees) {
        this.tvEmployees = tvEmployees;
        getChildren().add(tvEmployees);
    }

    public boolean isAdmin() {
        return chIsAdmin.isSelected();
    }

    public String getEmail() {
        return tfEmail.getText();
    }

    public String getPassword() {
        return tfPassword.getText();
    }
}
