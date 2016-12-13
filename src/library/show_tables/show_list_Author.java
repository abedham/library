package library.show_tables;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import library.AllClass.Author_book;
import library.AutoCompleteComboBoxListener;
import library.DBConnection;

public class show_list_Author {

    ListView<String> l_Author;

    ObservableList<String> ob = FXCollections.observableArrayList();
    ComboBox<String> cb;
    DBConnection db = new DBConnection();
    Connection conn = db.getConn();
    int book_id;
    ArrayList<Author_book> A = new ArrayList<>();

    public VBox getList_Author() throws SQLException {

        cb = new ComboBox<>();
        cb.setItems(ob);

        l_Author = new ListView<>();

        String updateTableSQL = "select * from book";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(updateTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                A.add(new Author_book(rs.getString("title"), rs.getInt("book_id")));
                update();

            }

            cb.setEditable(true);
            cb.valueProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue ov, String t, String t1) {

                    l_Author.getItems().clear();
                    for (int i = 0; i < A.size(); i++) {
                        if (A.get(i).getAuthor_name().equalsIgnoreCase(t1)) {
                            book_id = A.get(i).getBook_id();
                            break;
                        }
                    }

                    try {
                        String updateTableSQL = "select Author_name from Author_book where book_id = ?";
                        PreparedStatement preparedStatement = null;
                        preparedStatement = conn.prepareStatement(updateTableSQL);
                        preparedStatement.setInt(1, book_id);
                        ResultSet rs = preparedStatement.executeQuery();
                        while (rs.next()) {
                            l_Author.getItems().add(rs.getString("Author_name"));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(show_list_Author.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
            );

        } catch (SQLException ex) {
            Logger.getLogger(show_table_member.class.getName()).log(Level.SEVERE, null, ex);
        }
        new AutoCompleteComboBoxListener<>(cb);
        VBox v = new VBox(5, cb, l_Author);
        return v;

    }

    private void update() {

        ob.removeAll(ob);
        for (int i = 0; i < A.size(); i++) {
            ob.add(A.get(i).getAuthor_name());
        }
    }

}

