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
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.HBox;
import library.AllClass.member;
import library.show_tables.show_list_Author;
import static javafx.application.Application.launch;



public class test extends Application {


    public test() throws SQLException {

      
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {

        
  
        
        Button btn = new Button();
        btn.setText("Report");

        ArrayList<Integer> As = new ArrayList<>();
        As.add(852582148);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                    itext i = new itext();
                    i.getReprot();
                } catch (SQLException ex) {
                    Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                }
                
       
            }
        
        });

        HBox h = new HBox(10 , btn);

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
