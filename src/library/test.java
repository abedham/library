/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import library.show.show_data;
import library.AllClass.employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.HBox;
import static library.add.callableStatement;
import library.AllClass.book;
import library.AllClass.member;
import library.AllClass.borrow;
import library.AllClass.Author_book;
import library.AllClass.phone_number;
import library.AllClass.Publisher;
import library.AllClass.Reg_book;
import library.AllClass.Reg_member;
import library.AllClass.Section;
import library.AllClass.Supplies;

/**
 *
 * @author HP
 */
public class test extends Application {

    TableView<book> table;
    ObservableList<book> data = FXCollections.observableArrayList();

    static DBConnection db = new DBConnection();
    static Connection conn = db.getConn();
    static Statement stat = null;
    show_data sh = new show_data();

    add a = new add();

    public test() throws SQLException {

        data = sh.book_show();
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {

        table = new TableView<>();

        TableColumn tc1 = new TableColumn("book_id");
        tc1.setPrefWidth(200);
        tc1.setCellValueFactory(new PropertyValueFactory("book_id"));

        TableColumn tc2 = new TableColumn("mem_id");
        tc2.setPrefWidth(200);
        tc2.setCellValueFactory(new PropertyValueFactory("title"));

        table.setItems(data);
        table.getColumns().addAll(tc1, tc2);
        table.setMaxSize(600, 800);

        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        ArrayList<String> As = new ArrayList<>();
        As.add("PO1");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                    data.clear();
                    a.add_Book("YYYYYY", "true", 3, 1, As, 4);
                    data = sh.book_show();
                    table.setItems(data);
                } catch (SQLException ex) {
                    Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        HBox h = new HBox(10, table, btn);

        Scene scene = new Scene(h, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
