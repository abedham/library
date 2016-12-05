/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    private Label lbExpireDate = new Label("Expire Date");
    private Label lbPhoneNumber = new Label("Phone Number");

    private TextField tfMemberName = new TextField();
    private TextField tfMemberAddress = new TextField();
    private TextField tfPhoneNumber = new TextField();

    private Button btnAddMember = new Button("+");

    private DatePicker dpExpireDate = new DatePicker(LocalDate.now());

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

        lbExpireDate.setMinWidth(minWidthLabels);
        dpExpireDate.setMinWidth(minWidth);

        HBox hboxExpireDate = new HBox(10, lbExpireDate, dpExpireDate);

        lbPhoneNumber.setMinWidth(minWidthLabels);

        tfPhoneNumber.setMinWidth(minWidth);
        tfPhoneNumber.setPromptText("Phone Number");

        HBox hboxPhoneNumber = new HBox(10, lbPhoneNumber, tfPhoneNumber);

        setSpacing(spacing);
        getChildren().addAll(hboxMemberName, hboxMemberAddress,
                hboxPhoneNumber, hboxExpireDate, btnAddMember);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(padding));
    }

    private String getMemberName() {
        return tfMemberName.getText();
    }

    private String getMemberAddress() {
        return tfMemberAddress.getText();
    }

    private LocalDate getExpireDate() {
        return dpExpireDate.getValue();
    }

    private String getPhoneNumber() {
        return tfPhoneNumber.getText();
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

    public Label getLbPhoneNumber() {
        return lbPhoneNumber;
    }

    public void setLbPhoneNumber(Label lbPhoneNumber) {
        this.lbPhoneNumber = lbPhoneNumber;
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

    public TextField getTfPhoneNumber() {
        return tfPhoneNumber;
    }

    public void setTfPhoneNumber(TextField tfPhoneNumber) {
        this.tfPhoneNumber = tfPhoneNumber;
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

}
