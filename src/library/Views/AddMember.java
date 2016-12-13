/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author AbdelRahman
 */
public class AddMember extends VBox {

    private final int minWidth = 200;
    private final int minWidthLabels = 115;
    private final int spacing = 15;
    private final int padding = 10;

    private Label lbMemberName = new Label("Member Name");
    private Label lbMemberAddress = new Label("Member Address");
    private Label lbMemberEmail = new Label("Member Email");
    private Label lbExpireDate = new Label("Expire Date");
    private Label lbPhoneNumbers = new Label("Phone Numbers");

    private TextField tfMemberName = new TextField();
    private TextField tfMemberAddress = new TextField();
    private TextField tfMemberEmail = new TextField();

    private Button btnAddMember = new Button("+");

    private DatePicker dpExpireDate = new DatePicker(LocalDate.now());

    private ListView lvPhones = new ListView();
    private TextField tfPhone = new TextField();
    private List<TextField> tfsPhone = new ArrayList<>();
    private Button btnAddPhone = new Button("+");

    private TableView tableView;

    public AddMember() {
        initAddMemberView();
    }

    private void initAddMemberView() {
        lbMemberName.setMinWidth(minWidthLabels);

        tfMemberName.setMinWidth(minWidth);
        tfMemberName.setPromptText("Member Name");

        HBox hboxMemberName = new HBox(10, lbMemberName, tfMemberName);

        lbMemberAddress.setMinWidth(minWidthLabels);

        tfMemberAddress.setMinWidth(minWidth);
        tfMemberAddress.setPromptText("Member Address");

        HBox hboxMemberAddress = new HBox(10, lbMemberAddress, tfMemberAddress);

        lbMemberEmail.setMinWidth(minWidthLabels);

        tfMemberEmail.setMinWidth(minWidth);
        tfMemberEmail.setPromptText("Member Email");

        HBox hboxMemberEmail = new HBox(10, lbMemberEmail, tfMemberEmail);

        lbExpireDate.setMinWidth(minWidthLabels);
        dpExpireDate.setMinWidth(minWidth);

        HBox hboxExpireDate = new HBox(10, lbExpireDate, dpExpireDate);

        lbPhoneNumbers.setMinWidth(minWidthLabels);

        tfPhone.setMinWidth(minWidth);
        tfPhone.setPromptText("Phone Number");

        lbPhoneNumbers.setMinWidth(minWidthLabels);

        lvPhones.setItems(FXCollections.observableArrayList());
        tfPhone = new TextField();
        tfPhone.setPromptText("Phone Name");

        tfsPhone.add(tfPhone);
        lvPhones.setPrefHeight(100);
        lvPhones.setMaxWidth(minWidth);
        lvPhones.getItems().add(new HBox(5, tfPhone, btnAddPhone));
        btnAddPhone.setOnAction(e -> {
            int size = lvPhones.getItems().size();
            HBox hbox = ((HBox) lvPhones.getItems().get(size - 1));
            hbox.getChildren().remove(btnAddPhone);
            tfPhone = new TextField();
            tfPhone.setPromptText("Author Name");
            tfsPhone.add(tfPhone);
            lvPhones.getItems().add(new HBox(5, tfPhone, btnAddPhone));
        });
        HBox hblvPhones = new HBox(10, lbPhoneNumbers, lvPhones);

        hboxMemberName.setAlignment(Pos.CENTER);
        hblvPhones.setAlignment(Pos.CENTER);
        hboxExpireDate.setAlignment(Pos.CENTER);
        hboxMemberEmail.setAlignment(Pos.CENTER);
        hboxMemberAddress.setAlignment(Pos.CENTER);

        setSpacing(spacing);
        getChildren().addAll(new Label("Add new member"), hboxMemberName, hboxMemberAddress,
                hboxMemberEmail, hblvPhones, hboxExpireDate, btnAddMember);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(padding));
    }

    public String getMemberName() {
        return tfMemberName.getText();
    }

    public String getMemberAddress() {
        return tfMemberAddress.getText();
    }

    public LocalDate getExpireDate() {
        return dpExpireDate.getValue();
    }

    public List<String> getPhoneNumbers() {
        List<String> phones = new ArrayList<>();
        tfsPhone.stream().filter((tfPhone) -> (!tfPhone.getText().trim().isEmpty()))
                .forEach((tfPhone) -> {
                    phones.add(tfPhone.getText());
                });
        return phones;
    }

    public Label getLbMemberName() {
        return lbMemberName;
    }

    public void setLbMemberName(Label lbMemberName) {
        this.lbMemberName = lbMemberName;
    }

    public Label getLbMemberAddress() {
        return lbMemberAddress;
    }

    public void setLbMemberAddress(Label lbMemberAddress) {
        this.lbMemberAddress = lbMemberAddress;
    }

    public Label getLbExpireDate() {
        return lbExpireDate;
    }

    public void setLbExpireDate(Label lbExpireDate) {
        this.lbExpireDate = lbExpireDate;
    }

    public Label getLbPhoneNumbers() {
        return lbPhoneNumbers;
    }

    public void setLbPhoneNumbers(Label lbPhoneNumbers) {
        this.lbPhoneNumbers = lbPhoneNumbers;
    }

    public TextField getTfMemberName() {
        return tfMemberName;
    }

    public void setTfMemberName(TextField tfMemberName) {
        this.tfMemberName = tfMemberName;
    }

    public TextField getTfMemberAddress() {
        return tfMemberAddress;
    }

    public void setTfMemberAddress(TextField tfMemberAddress) {
        this.tfMemberAddress = tfMemberAddress;
    }

    public Button getBtnAddMember() {
        return btnAddMember;
    }

    public void setBtnAddMember(Button btnAddMember) {
        this.btnAddMember = btnAddMember;
    }

    public DatePicker getDpExpireDate() {
        return dpExpireDate;
    }

    public void setDpExpireDate(DatePicker dpExpireDate) {
        this.dpExpireDate = dpExpireDate;
    }

    public String getMemberEmail() {
        return tfMemberEmail.getText();
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
        getChildren().add(tableView);
    }
}
