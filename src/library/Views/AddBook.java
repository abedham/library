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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author AbdelRahman
 */
public class AddBook extends VBox {

    private final int minWidth = 200;
    private final int minWidthLabels = 115;
    private final int spacing = 15;
    private final int padding = 10;
    private Label lbBookName = new Label("Book Name");
    private Label lbPublisher = new Label("Publisher");
    private Label lbSection = new Label("Section");

    private TextField tfBookName = new TextField();

    private ComboBox<String> cbSection = new ComboBox<>();
    private ComboBox<String> cbPublisher = new ComboBox<>();

    private ListView lvAuthor = new ListView();

    private Button btnAddAuthor = new Button("+");
    private Button btnAddBook = new Button("+");

    public AddBook() {
        initAddBookView();
    }

    private void initAddBookView() {

        lbBookName.setMinWidth(minWidthLabels);

        tfBookName.setMinWidth(minWidth);
        tfBookName.setPromptText("Book Name");

        HBox hboxBookName = new HBox(10, lbBookName, tfBookName);

        lbSection.setMinWidth(minWidthLabels);

        cbSection.setMinWidth(minWidth);

        HBox hboxSection = new HBox(10, lbSection, cbSection);

        lbPublisher.setMinWidth(minWidthLabels);

        cbPublisher.setMinWidth(minWidth);

        HBox hboxPublisher = new HBox(10, lbPublisher, cbPublisher);

        lvAuthor.setItems(FXCollections.observableArrayList());
        lvAuthor.getItems().add(new HBox(5, new TextField("Author Name 1"), btnAddAuthor));
        btnAddAuthor.setOnAction(e -> {
            int size = lvAuthor.getItems().size();
            HBox hbox = ((HBox) lvAuthor.getItems().get(size - 1));
            hbox.getChildren().remove(btnAddAuthor);
            lvAuthor.getItems().add(new HBox(5, new TextField("Author Name 1"), btnAddAuthor));
        });

        setSpacing(spacing);
        getChildren().addAll(hboxBookName, hboxSection, hboxPublisher, lvAuthor, btnAddBook);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(padding));

    }

    public String getLbBookName() {
        return lbBookName.getText();
    }

    public void setLbBookName(Label lbBookName) {
        this.lbBookName = lbBookName;
    }

    public String getLbPublisher() {
        return lbPublisher.getText();
    }

    public void setLbPublisher(Label lbPublisher) {
        this.lbPublisher = lbPublisher;
    }

    public String getLbSection() {
        return lbSection.getText();
    }

    public void setLbSection(Label lbSection) {
        this.lbSection = lbSection;
    }

    public String getTfBookName() {
        return tfBookName.getText();
    }

    public void setTfBookName(TextField tfBookName) {
        this.tfBookName = tfBookName;
    }

    public ObservableList<String> getCbSection() {
        return cbSection.getItems();
    }

    public void setCbSection(ComboBox<String> cbSection) {
        this.cbSection = cbSection;
    }

    public ObservableList<String> getCbPublisher() {
        return cbPublisher.getItems();
    }

    public void setCbPublisher(ComboBox<String> cbPublisher) {
        this.cbPublisher = cbPublisher;
    }

    public ObservableList getLvAuthor() {
        return lvAuthor.getItems();
    }

    public void setLvAuthor(ListView lvAuthor) {
        this.lvAuthor = lvAuthor;
    }

    public Button getBtnAddAuthor() {
        return btnAddAuthor;
    }

    public void setBtnAddAuthor(Button btnAddAuthor) {
        this.btnAddAuthor = btnAddAuthor;
    }

    public Button getBtnAddBook() {
        return btnAddBook;
    }

    public void setBtnAddBook(Button btnAddBook) {
        this.btnAddBook = btnAddBook;
    }
}
