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
import library.AllClass.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import static library.add.callableStatement;
import library.AllClass.book;
import library.AllClass.member;
import library.AllClass.borrow;
import library.AllClass.Author_book;
import library.AllClass.phone_number;
import library.AllClass.Publisher;
import library.AllClass.BookRegisteration;
import library.AllClass.Reg_member;
import library.AllClass.Section;
import library.AllClass.Supplies;
import library.show_tables.show_book_table;
import library.show_tables.show_table_member;
import library.show_tables.show_employee_table;
import library.show_tables.show_list_Author;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;

/**
 *
 * @author HP
 */
public class test extends Application {

    TableView<member> table;
    ObservableList<member> data = FXCollections.observableArrayList();

    static DBConnection db = new DBConnection();
    static Connection conn = db.getConn();
    static Statement stat = null;

    show_list_Author sh = new show_list_Author();

    public test() throws SQLException {

        // data = sh.Author_book_show();
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {

        //    sla.getList_Author( data);
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        ArrayList<Integer> As = new ArrayList<>();
        As.add(852582148);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
            /*
             try {

             data.clear();
             a.add_Member("Tamer", "T@gmail.com", As, 3, "Gaza", "1/1/17");
             data = sh.member_show();
             table.setItems(data);
             } catch (SQLException ex) {
             Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                
                    
             }
             */
        });

        HBox h = new HBox(10, sh.getList_Author(), btn);

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
