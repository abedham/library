/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import javafx.collections.FXCollections;
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
public class AddBook {

    private final int minWidth = 200;
    private final int minWidthLabels = 115;
    private final int spacing = 15;
    private final int padding = 10;

    private VBox getAddBookView() {

        Label lbBookName = new Label("Book Name");
        lbBookName.setMinWidth(minWidthLabels);

        TextField tfBookName = new TextField();
        tfBookName.setMinWidth(minWidth);
        tfBookName.setPromptText("Book Name");

        HBox hboxBookName = new HBox(10, lbBookName, tfBookName);

        Label lbSection = new Label("Section");
        lbSection.setMinWidth(minWidthLabels);

        ComboBox<String> cbSection = new ComboBox<>();
        cbSection.setMinWidth(minWidth);

        HBox hboxSection = new HBox(10, lbSection, cbSection);

        Label lbPublisher = new Label("Publisher");
        lbPublisher.setMinWidth(minWidthLabels);

        ComboBox<String> cbPublisher = new ComboBox<>();
        cbPublisher.setMinWidth(minWidth);

        HBox hboxPublisher = new HBox(10, lbPublisher, cbPublisher);

        ListView lvAuthor = new ListView();
        lvAuthor.setItems(FXCollections.observableArrayList());
        Button btnAddAuthor = new Button("+");
        lvAuthor.getItems().add(new HBox(5, new TextField("Author Name 1"), btnAddAuthor));
        btnAddAuthor.setOnAction(e -> {
            int size = lvAuthor.getItems().size();
            HBox hbox = ((HBox) lvAuthor.getItems().get(size - 1));
            hbox.getChildren().remove(btnAddAuthor);
            lvAuthor.getItems().add(new HBox(5, new TextField("Author Name 1"), btnAddAuthor));
        });

        Button btnAddBook = new Button("+");

        VBox vbox = new VBox(15, hboxBookName, hboxSection, hboxPublisher, lvAuthor, btnAddBook);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }
}
