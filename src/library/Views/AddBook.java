/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import java.util.ArrayList;
import java.util.List;
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
import library.AllClass.Publisher;
import library.AllClass.Section;

/**
 *
 * @author AbdelRahman
 */
public class AddBook extends VBox {

    private final int minWidth = 200;
    private final int minWidthLabels = 115;
    private final int spacing = 15;
    private final int padding = 10;

    private Label lbBookName = new Label("Book Name:");
    private Label lbPublisher = new Label("Publisher:");
    private Label lbSection = new Label("Section:");
    private Label lbAuthors = new Label("Authors:");
    private TextField tfBookName = new TextField();
    TextField tfAuthor;

    private ComboBox<Section> cbSection = new ComboBox<>();
    private ComboBox<Publisher> cbPublisher = new ComboBox<>();

    private ListView lvAuthors = new ListView();

    private Button btnAddAuthor = new Button("+");
    private Button btnAddBook = new Button("+");

    private List<TextField> tfsAuthors = new ArrayList<>();

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

//        new AutoCompleteComboBoxListener<>(cbPublisher);
//        new AutoCompleteComboBoxListener<>(cbSection);
        HBox hboxPublisher = new HBox(10, lbPublisher, cbPublisher);

        hboxBookName.setAlignment(Pos.CENTER);

        hboxPublisher.setAlignment(Pos.CENTER);

        hboxSection.setAlignment(Pos.CENTER);

        lbAuthors.setMinWidth(minWidthLabels);

        lvAuthors.setItems(FXCollections.observableArrayList());
        tfAuthor = new TextField();

        tfAuthor.setPromptText(
                "Author Name");

        tfsAuthors.add(tfAuthor);

        lvAuthors.setPrefHeight(
                100);
        lvAuthors.setMaxWidth(minWidth);

        lvAuthors.getItems()
                .add(new HBox(5, tfAuthor, btnAddAuthor));
        btnAddAuthor.setOnAction(e
                -> {
            int size = lvAuthors.getItems().size();
            HBox hbox = ((HBox) lvAuthors.getItems().get(size - 1));
            hbox.getChildren().remove(btnAddAuthor);
            tfAuthor = new TextField();
            tfAuthor.setPromptText("Author Name");
            tfsAuthors.add(tfAuthor);
            lvAuthors.getItems().add(new HBox(5, tfAuthor, btnAddAuthor));
        }
        );
        HBox hblvAuthors = new HBox(10, lbAuthors, lvAuthors);

        hblvAuthors.setAlignment(Pos.CENTER);

        setSpacing(spacing);

        getChildren()
                .addAll(new Label("Add new book"), hboxBookName, hboxPublisher, hboxSection, hblvAuthors, btnAddBook);
        setAlignment(Pos.CENTER);

        setPadding(
                new Insets(padding));

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

    public ObservableList getLvAuthor() {
        return lvAuthors.getItems();
    }

    public void setLvAuthors(ListView lvAuthors) {
        this.lvAuthors = lvAuthors;
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

    public String getBookName() {
        return tfBookName.getText();
    }

    public Publisher getPublisher() {
        return cbPublisher.getValue();
    }

    public Section getSection() {
        return cbSection.getValue();//cbSection.getSelectionModel().getSelectedItem();
    }

    public List<String> getAuthors() {
        List<String> authors = new ArrayList<>();
        tfsAuthors.stream().filter((tfAuthor) -> (!tfAuthor.getText().trim().isEmpty()))
                .forEach((tfAuthor) -> {
                    authors.add(tfAuthor.getText());
                });
        return authors;
    }

    public void setPublishers(ObservableList<Publisher> publishers) {
        cbPublisher.setItems(publishers);
    }

    public ObservableList<Publisher> getPublishers() {
        return cbPublisher.getItems();
    }

    public void setSections(ObservableList<Section> sections) {
        cbSection.setItems(sections);
    }

    public ObservableList<Section> getSections() {
        return cbSection.getItems();
    }

    public Label getLbAuthors() {
        return lbAuthors;
    }

    public void setLbAuthors(Label lbAuthors) {
        this.lbAuthors = lbAuthors;
    }

    public TextField getTfAuthor() {
        return tfAuthor;
    }

    public void setTfAuthor(TextField tfAuthor) {
        this.tfAuthor = tfAuthor;
    }

    public ComboBox<Section> getCbSection() {
        return cbSection;
    }

    public void setCbSection(ComboBox<Section> cbSection) {
        this.cbSection = cbSection;
    }

    public ComboBox<Publisher> getCbPublisher() {
        return cbPublisher;
    }

    public void setCbPublisher(ComboBox<Publisher> cbPublisher) {
        this.cbPublisher = cbPublisher;
    }

    public List<TextField> getTfsAuthors() {
        return tfsAuthors;
    }

    public void setTfsAuthors(List<TextField> tfsAuthors) {
        this.tfsAuthors = tfsAuthors;
    }

}
