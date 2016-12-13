/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author AbdelRahman
 */
public class AddPublisher extends VBox {

    private final int minWidth = 200;
    private final int minWidthLabels = 115;
    private final int spacing = 15;
    private final int padding = 10;

    Label lbPublisherName = new Label("Publisher Name");
    Label lbPublisherAddress = new Label("Publisher Address");

    TextField tfPublisherName = new TextField();
    TextField tfPublisherAddress = new TextField();

    Button btnAddPublisher = new Button("+");

    public AddPublisher() {
        initAddPublisherView();
    }

    private void initAddPublisherView() {
        lbPublisherName.setMinWidth(minWidthLabels);

        tfPublisherName.setMinWidth(minWidth);
        tfPublisherName.setPromptText("Publisher Name");
        HBox hboxPublisherName = new HBox(10, lbPublisherName, tfPublisherName);

        lbPublisherAddress.setMinWidth(minWidthLabels);

        tfPublisherAddress.setMinWidth(minWidth);
        tfPublisherAddress.setPromptText("Publisher Address");
        HBox hboxPublisherAddress = new HBox(10, lbPublisherAddress, tfPublisherAddress);

        hboxPublisherAddress.setAlignment(Pos.CENTER);
        hboxPublisherName.setAlignment(Pos.CENTER);

        setSpacing(spacing);
        getChildren().addAll(new Label("Add new publisher"),hboxPublisherName, hboxPublisherAddress, btnAddPublisher);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(padding));
    }

    public String getPublisherName() {
        return tfPublisherName.getText();
    }

    public String getPublisherAddress() {
        return tfPublisherAddress.getText();
    }

    public TextField getTfPublisherName() {
        return tfPublisherName;
    }

    public void setTfPublisherName(TextField tfPublisherName) {
        this.tfPublisherName = tfPublisherName;
    }

    public TextField getTfPublisherAddress() {
        return tfPublisherAddress;
    }

    public void setTfPublisherAddress(TextField tfPublisherAddress) {
        this.tfPublisherAddress = tfPublisherAddress;
    }

    public Button getBtnAddPublisher() {
        return btnAddPublisher;
    }

    public void setBtnAddPublisher(Button btnAddPublisher) {
        this.btnAddPublisher = btnAddPublisher;
    }

}
