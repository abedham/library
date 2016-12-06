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
 * @author Itach
 */
public class AddSection extends VBox {

    private final int minWidth = 200;
    private final int minWidthLabels = 200;
    private final int spacing = 15;
    private final int padding = 10;

    private Label lbSectionName = new Label("Section Name");

    private TextField tfSectionName = new TextField("Section Name");

    private Button btnAddSection = new Button("+");

    public AddSection() {
        initAddSectionView();
    }

    private void initAddSectionView() {

        lbSectionName.setMinWidth(minWidthLabels);

        tfSectionName.setMinWidth(minWidth);

        HBox hboxSectionName = new HBox(10, lbSectionName, tfSectionName);
        hboxSectionName.setAlignment(Pos.CENTER);
        setSpacing(spacing);
        getChildren().addAll(hboxSectionName, btnAddSection);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(padding));

    }

    public String getLbSectionName() {
        return lbSectionName.getText();
    }

    public void setLbSectionName(Label lbSectionName) {
        this.lbSectionName = lbSectionName;
    }

    public String getTfSectionName() {
        return tfSectionName.getText();
    }

    public void setTfSectionName(TextField tfSectionName) {
        this.tfSectionName = tfSectionName;
    }

    public Button getBtnAddSection() {
        return btnAddSection;
    }

    public void setBtnAddSection(Button btnAddSection) {
        this.btnAddSection = btnAddSection;
    }

    public String getSectionName() {
        return tfSectionName.getText();
    }
}
