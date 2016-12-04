/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author abdelrahman
 */
public class Library extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(getAddBookView(), 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox getSignInView() {

        TextField tfUserName = new TextField();
        tfUserName.setPromptText("User Name");

        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Password");

        Button btnLogin = new Button("Login");
        VBox vbox = new VBox(15, tfUserName, tfPassword, btnLogin);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox getAddBookView() {

        Label lbBookName = new Label("Book Name");
        TextField tfBookName = new TextField();
        tfBookName.setPromptText("Book Name");
        HBox hboxBookName = new HBox(10, lbBookName, tfBookName);

        Label lbSection = new Label("Section");
        ComboBox<String> cbSection = new ComboBox<>();
        HBox hboxSection = new HBox(10, lbSection, cbSection);

        Label lbPublisher = new Label("Publisher");
        ComboBox<String> cbPublisher = new ComboBox<>();
        HBox hboxPublisher = new HBox(10, lbPublisher, cbPublisher);

        ListView<CheckBox> lvAuthor = new ListView<>();
        lvAuthor.setItems(FXCollections.observableArrayList());
        lvAuthor.getItems().add(new CheckBox("Name 1"));
        lvAuthor.getItems().add(new CheckBox("Name 2"));
        lvAuthor.getItems().add(new CheckBox("Name 3"));
        //use setUserData to set data for checkBox
        //new CheckBox().setUserData();
        VBox vbox = new VBox(15, hboxBookName, hboxSection, hboxPublisher, lvAuthor);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
