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
import library.AllClass.member;
import library.DBConnection;
import library.show.show_data;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class show_table_member {

    
    
    TableView<member> table_member;
    static DBConnection db = new DBConnection();
    static Connection conn = db.getConn();
    static Statement stat = null;

    public TableView getTable_member(ObservableList ob) {

        table_member = new TableView<>();

        table_member.setEditable(true);

        TableColumn tc1 = new TableColumn("mem_id");
        tc1.setPrefWidth(200);
        tc1.setCellValueFactory(new PropertyValueFactory("mem_id"));
        tc1.setPrefWidth(100);

        Callback<TableColumn, TableCell> cellFactory
                = new Callback<TableColumn, TableCell>() {

                    @Override
                    public TableCell call(TableColumn p) {
                        return new show_table_member.EditingCell();
                    }
                };

        TableColumn tc2 = new TableColumn("name");
        tc2.setPrefWidth(200);
        tc2.setCellValueFactory(new PropertyValueFactory("name"));
        tc2.setCellFactory(cellFactory);
        tc2.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<member, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<member, String> t) {
                        ((member) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setName(t.getNewValue());

                        int mem_id = table_member.getSelectionModel().getSelectedItem().getMem_id();
                        String updateTableSQL = "UPDATE member SET name = ? WHERE mem_id = ?";
                        PreparedStatement preparedStatement = null;
                        try {
                            preparedStatement = conn.prepareStatement(updateTableSQL);
                            preparedStatement.setString(1, t.getNewValue());
                            preparedStatement.setInt(2, mem_id);
                            preparedStatement.executeUpdate();

                        } catch (SQLException ex) {
                            Logger.getLogger(show_table_member.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });

        
        
        TableColumn tc3 = new TableColumn("email");
        tc3.setPrefWidth(200);
        tc3.setCellValueFactory(new PropertyValueFactory("email"));
        tc3.setCellFactory(cellFactory);
        tc3.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<member, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<member, String> t) {
                        ((member) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setName(t.getNewValue());

                        int mem_id = table_member.getSelectionModel().getSelectedItem().getMem_id();
                        String updateTableSQL = "UPDATE member SET email = ? WHERE mem_id = ?";
                        PreparedStatement preparedStatement = null;
                        try {
                            preparedStatement = conn.prepareStatement(updateTableSQL);
                            preparedStatement.setString(1, t.getNewValue());
                            preparedStatement.setInt(2, mem_id);
                            preparedStatement.executeUpdate();

                        } catch (SQLException ex) {
                            Logger.getLogger(show_table_member.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });

        TableColumn tc4 = new TableColumn("address");
        tc4.setPrefWidth(200);
        tc4.setCellValueFactory(new PropertyValueFactory("address"));
        tc4.setCellFactory(cellFactory);
        tc4.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<member, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<member, String> t) {
                        ((member) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setName(t.getNewValue());

                        int mem_id = table_member.getSelectionModel().getSelectedItem().getMem_id();
                        String updateTableSQL = "UPDATE member SET address = ? WHERE mem_id = ?";
                        PreparedStatement preparedStatement = null;
                        try {
                            preparedStatement = conn.prepareStatement(updateTableSQL);
                            preparedStatement.setString(1, t.getNewValue());
                            preparedStatement.setInt(2, mem_id);
                            preparedStatement.executeUpdate();

                        } catch (SQLException ex) {
                            Logger.getLogger(show_table_member.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });

        
        table_member.setItems(ob);
        table_member.getColumns().addAll(tc1, tc2 , tc3 , tc4);
        table_member.setMaxSize(600, 800);

        return table_member;

    }

    
    
    
    class EditingCell extends TableCell<member, String> {

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
            } else {
                if (isEditing()) {
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
