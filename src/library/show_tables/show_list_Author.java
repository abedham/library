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
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import library.AllClass.Author_book;
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

class AutoCompleteComboBoxListener<T> implements EventHandler<KeyEvent> {

    private ComboBox comboBox;
    private StringBuilder sb;
    private ObservableList<T> data;
    private boolean moveCaretToPos = false;
    private int caretPos;

    public AutoCompleteComboBoxListener(final ComboBox comboBox) {
        this.comboBox = comboBox;
        sb = new StringBuilder();
        data = comboBox.getItems();
        comboBox.setPromptText("إختر من القائمة");

        this.comboBox.setEditable(true);
        this.comboBox.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent t) {
                comboBox.hide();
            }
        });
        this.comboBox.setOnKeyReleased(AutoCompleteComboBoxListener.this);
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.UP) {
            caretPos = -1;
            moveCaret(comboBox.getEditor().getText().length());
            return;
        } else if (event.getCode() == KeyCode.DOWN) {
            if (!comboBox.isShowing()) {
                comboBox.show();
            }
            caretPos = -1;
            moveCaret(comboBox.getEditor().getText().length());
            return;
        } else if (event.getCode() == KeyCode.BACK_SPACE) {
            moveCaretToPos = true;
            caretPos = comboBox.getEditor().getCaretPosition();
        } else if (event.getCode() == KeyCode.DELETE) {
            moveCaretToPos = true;
            caretPos = comboBox.getEditor().getCaretPosition();
        }

        if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT
                || event.isControlDown() || event.getCode() == KeyCode.HOME
                || event.getCode() == KeyCode.END || event.getCode() == KeyCode.TAB) {
            return;
        }

        ObservableList list = FXCollections.observableArrayList();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).toString().toLowerCase().startsWith(
                    AutoCompleteComboBoxListener.this.comboBox
                    .getEditor().getText().toLowerCase())) {
                list.add(data.get(i));
            }
        }
        String t = comboBox.getEditor().getText();

        comboBox.setItems(list);
        comboBox.getEditor().setText(t);
        if (!moveCaretToPos) {
            caretPos = -1;
        }
        moveCaret(t.length());
        if (!list.isEmpty()) {
            comboBox.show();
        }
    }

    private void moveCaret(int textLength) {
        if (caretPos == -1) {
            comboBox.getEditor().positionCaret(textLength);
        } else {
            comboBox.getEditor().positionCaret(caretPos);
        }
        moveCaretToPos = false;
    }

}

