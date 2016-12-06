/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author AbdelRahman
 */
public class MemberData extends VBox {

    private final int minWidth = 200;
    private final int minWidthLabels = 115;
    private final int spacing = 15;
    private final int padding = 10;

    private Label lbMemberID = new Label("ID");
    private Label lbMemberName = new Label("Name");
    private Label lbExpireDate = new Label("Expire Date");
    private Label lbPhoneNumber = new Label("Phone Number");
    private Label lbMemberAddress = new Label("Member Address");

    private TextField tfMemberID = new TextField();
    private TextField tfMemberName = new TextField();
    private TextField tfMemberAddress = new TextField();
    private TextField tfPhoneNumber = new TextField();
    private TextField tfExpireDate = new TextField();

    private TableView tableView = new TableView();

    private TableColumn tcBookName = new TableColumn("Book Name");
    private TableColumn tcBorrowDate = new TableColumn("Borrow Date");
    private TableColumn tcReturnDate = new TableColumn("Return Date");
    private TableColumn tcStatus = new TableColumn("Status");

    private ObservableList date = FXCollections.observableArrayList();

    public MemberData() {
        initMemberDataView();
    }

    private void initTableView() {
        tableView.setItems(date);
        tableView.setMaxWidth(minWidth + minWidthLabels + 200);
        tcBookName.setMinWidth(minWidth);
        tcBorrowDate.setMinWidth((minWidthLabels + 200) / 3);
        tcReturnDate.setMinWidth((minWidthLabels + 200) / 3);
        tcStatus.setMinWidth((minWidthLabels + 200) / 3);
        tableView.getColumns().addAll(tcBookName, tcBorrowDate, tcReturnDate, tcStatus);
    }

    private void initMemberDataView() {
        initTableView();

        tfExpireDate.setEditable(false);
        tfMemberAddress.setEditable(false);
        tfMemberName.setEditable(false);
        tfPhoneNumber.setEditable(false);

        lbMemberName.setMinWidth(minWidthLabels);

        tfMemberName.setMinWidth(minWidth);
        tfMemberName.setPromptText("Member Name");

        HBox hboxMemberName = new HBox(10, lbMemberName, tfMemberName);

        lbMemberAddress.setMinWidth(minWidthLabels);

        tfMemberAddress.setMinWidth(minWidth);
        tfMemberAddress.setPromptText("Member Address");

        HBox hboxMemberAddress = new HBox(10, lbMemberAddress, tfMemberAddress);

        lbExpireDate.setMinWidth(minWidthLabels);

        tfExpireDate.setMinWidth(minWidth);
        tfExpireDate.setPromptText("Expire Date");
        HBox hboxExpireDate = new HBox(10, lbExpireDate, tfExpireDate);

        lbPhoneNumber.setMinWidth(minWidthLabels);

        tfPhoneNumber.setMinWidth(minWidth);
        tfPhoneNumber.setPromptText("Phone Number");

        HBox hboxPhoneNumber = new HBox(10, lbPhoneNumber, tfPhoneNumber);

        hboxMemberName.setAlignment(Pos.CENTER);
        hboxPhoneNumber.setAlignment(Pos.CENTER);
        hboxExpireDate.setAlignment(Pos.CENTER);
        hboxMemberAddress.setAlignment(Pos.CENTER);

        setSpacing(spacing);
        getChildren().addAll(hboxMemberName, hboxMemberAddress,
                hboxPhoneNumber, hboxExpireDate, tableView);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(padding));
    }

    public TextField getTfMemberID() {
        return tfMemberID;
    }

    public void setTfMemberID(TextField tfMemberID) {
        this.tfMemberID = tfMemberID;
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

    public TextField getTfExpireDate() {
        return tfExpireDate;
    }

    public void setTfExpireDate(TextField tfExpireDate) {
        this.tfExpireDate = tfExpireDate;
    }

    public String getMemberId() {
        return tfMemberID.getText();
    }

    public void setExpireDate(String expireDate) {
        tfExpireDate.setText(expireDate);
    }

    public void setMemberName(String memberName) {
        tfMemberName.setText(memberName);
    }

    public void setPhoneNumber(String phoneNumber) {
        tfPhoneNumber.setText(phoneNumber);
    }

    public void setMemberAddress(String memberAddress) {
        tfMemberAddress.setText(memberAddress);
    }

}
