package library.show_tables;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.util.Callback;
import library.AllClass.book;
import library.DBConnection;
import library.show.show_data;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class show_book_table {

    TableView<book> table_book;
    static DBConnection db = new DBConnection();
    static Connection conn = db.getConn();
    static Statement stat = null;

    public TableView getTable_book(ObservableList ob) {

        table_book = new TableView<>();

        table_book.setEditable(true);

        TableColumn tc1 = new TableColumn("book_id");
        tc1.setPrefWidth(200);
        tc1.setCellValueFactory(new PropertyValueFactory("book_id"));
        tc1.setPrefWidth(100);
        Callback<TableColumn, TableCell> cellFactory
                = new Callback<TableColumn, TableCell>() {

            @Override
            public TableCell call(TableColumn p) {
                return new show_book_table.EditingCell();
            }
        };

        TableColumn tc2 = new TableColumn("title");
        tc2.setPrefWidth(200);
        tc2.setCellValueFactory(new PropertyValueFactory("title"));
        tc2.setCellFactory(cellFactory);
        tc2.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<book, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<book, String> t) {
                ((book) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setTitle(t.getNewValue());

                int book_id = table_book.getSelectionModel().getSelectedItem().getBook_id();
                String updateTableSQL = "UPDATE book SET title = ? WHERE book_id = ?";
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = conn.prepareStatement(updateTableSQL);
                    preparedStatement.setString(1, t.getNewValue());
                    preparedStatement.setInt(2, book_id);
                    preparedStatement.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(show_book_table.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        table_book.setItems(ob);
        table_book.getColumns().addAll(tc1, tc2);
        table_book.setMaxSize(600, 800);

        return table_book;

    }

    class EditingCell extends TableCell<book, String> {

        private TextField textField;

        public EditingCell() {
        }

        @Override
        public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }

            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.selectAll();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText(String.valueOf(getItem()));
            setContentDisplay(ContentDisplay.TEXT_ONLY);

        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());

                }

                setGraphic(textField);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }

        private void createTextField() {

            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);

            textField.setOnKeyPressed(e -> {

                if (e.getCode() == KeyCode.ENTER) {
                    commitEdit((textField.getText()));

                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }

}
