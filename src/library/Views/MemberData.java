/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import library.AllClass.MemberBook;
import library.Model;

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
    private Label lbMemberEmail = new Label("Member Email");

    private TextField tfMemberID = new TextField();
    private TextField tfMemberName = new TextField();
    private TextField tfMemberAddress = new TextField();
    private TextField tfPhoneNumber = new TextField();
    private TextField tfExpireDate = new TextField();
    private TextField tfMemberEmail = new TextField();

    private TableView<MemberBook> tableView = new TableView<>();

    private TableColumn<MemberBook, Integer> tcBookID = new TableColumn("Book id");
    private TableColumn<MemberBook, String> tcBookName = new TableColumn("Book Name");
    private TableColumn<MemberBook, String> tcBorrowDate = new TableColumn("Borrow Date");
    private TableColumn<MemberBook, String> tcReturnDate = new TableColumn("Return Date");
    private TableColumn<MemberBook, String> tcStatus = new TableColumn("Status");
    private TableColumn<MemberBook, String> tcAction = new TableColumn("Action");

    private ObservableList data = FXCollections.observableArrayList();

    public MemberData() {
        initMemberDataView();
    }

    private void initTableView() {
        tableView.setItems(data);
        tableView.setMaxWidth(minWidth + minWidthLabels + 340);
        tcBookID.setMinWidth(50);
        tcBookID.setMaxWidth(50);
        tcBookName.setMinWidth(minWidth + 30);
        tcBorrowDate.setMinWidth((minWidthLabels + 200) / 3);
        tcReturnDate.setMinWidth((minWidthLabels + 200) / 3);
        tcStatus.setMinWidth((minWidthLabels + 200) / 3);
        tcStatus.setMinWidth((minWidthLabels + 200) / 3);
        tcAction.setMinWidth(60);
        tcAction.setMaxWidth(60);
        tableView.getColumns().addAll(tcBookID, tcBookName, tcBorrowDate, tcReturnDate, tcStatus, tcAction);
        tcBookID.setCellValueFactory(new PropertyValueFactory("bookId"));
        tcBookName.setCellValueFactory(new PropertyValueFactory("bookName"));
        tcBorrowDate.setCellValueFactory(new PropertyValueFactory("borrowDate"));
        tcReturnDate.setCellValueFactory(new PropertyValueFactory("returnDate"));
        tcStatus.setCellValueFactory(new PropertyValueFactory("status"));
        tcAction.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        tcAction.setCellFactory(e -> {
            return new TableCell<MemberBook, String>() {
                final Button btn = new Button("Return");

                @Override
                public void updateItem(String item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                    } else {
                        MemberBook memberBook = getTableView().getItems().get(getIndex());
                        btn.setOnAction(e -> {
                            memberDataBtnAction(memberBook);
                            getTableView().refresh();
                            btn.setDisable(true);
                        });
                        setGraphic(btn);
                        if ("Returned".equals(memberBook.getStatus())) {
                            btn.setDisable(true);
                        }
                    }
                    setText(null);
                }

            };
        });
    }

    private void memberDataBtnAction(MemberBook memberBook) {
        if ("Not returned".equals(memberBook.getStatus())) {
            Model.returnBook(memberBook.getMemberId(), memberBook.getBookId());
            memberBook.setStatus("Returned");
        }
    }

    private void initMemberDataView() {
        initTableView();
        tfMemberID.setPromptText("Member ID");
        tfMemberID.setMinWidth(minWidth);
        lbMemberID.setMinWidth(minWidthLabels);

        HBox hboxMemberId = new HBox(10, lbMemberID, tfMemberID);

        tfMemberEmail.setPromptText("Member Email");
        tfMemberEmail.setMinWidth(minWidth);
        lbMemberEmail.setMinWidth(minWidthLabels);

        HBox hboxMemberEmail = new HBox(10, lbMemberEmail, tfMemberEmail);

        tfExpireDate.setEditable(false);
        tfMemberAddress.setEditable(false);
        tfMemberName.setEditable(false);
        tfPhoneNumber.setEditable(false);
        tfMemberEmail.setEditable(false);

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

        hboxMemberId.setAlignment(Pos.CENTER);
        hboxMemberEmail.setAlignment(Pos.CENTER);
        hboxMemberName.setAlignment(Pos.CENTER);
        hboxPhoneNumber.setAlignment(Pos.CENTER);
        hboxExpireDate.setAlignment(Pos.CENTER);
        hboxMemberAddress.setAlignment(Pos.CENTER);

        setSpacing(spacing);
        getChildren().addAll(hboxMemberId, hboxMemberName, hboxMemberAddress,
                hboxPhoneNumber, hboxMemberEmail, hboxExpireDate, tableView);
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

    public int getMemberId() {
        return Integer.parseInt(tfMemberID.getText());
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

    public TableView getTableView() {
        return tableView;
    }

    public TableColumn getTcBookName() {
        return tcBookName;
    }

    public TableColumn getTcBorrowDate() {
        return tcBorrowDate;
    }

    public TableColumn getTcReturnDate() {
        return tcReturnDate;
    }

    public TableColumn getTcStatus() {
        return tcStatus;
    }

    public void setEmail(String email) {
        tfMemberEmail.setText(email);
    }

}
