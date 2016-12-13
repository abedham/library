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
import library.DBConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import library.AllClass.Employee;

public class show_employee_table {

    TableView<Employee> table_emp;
    static DBConnection db = new DBConnection();
    static Connection conn = db.getConn();
    static Statement stat = null;

    public TableView getTable_emp(ObservableList ob) {

        table_emp = new TableView<>();

        table_emp.setEditable(true);

        TableColumn tc1 = new TableColumn("emp_id");
        tc1.setPrefWidth(200);
        tc1.setCellValueFactory(new PropertyValueFactory("emp_id"));
        tc1.setPrefWidth(100);

        Callback<TableColumn, TableCell> cellFactory
                = new Callback<TableColumn, TableCell>() {

            @Override
            public TableCell call(TableColumn p) {
                return new show_employee_table.EditingCell();
            }
        };

        TableColumn tc2 = new TableColumn("emp_name");
        tc2.setPrefWidth(200);
        tc2.setCellValueFactory(new PropertyValueFactory("emp_name"));
        tc2.setCellFactory(cellFactory);
        tc2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, String> t) {
                ((Employee) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setEmp_name(t.getNewValue());

                int emp_id = table_emp.getSelectionModel().getSelectedItem().getEmp_id();
                String updateTableSQL = "UPDATE employee SET name = ? WHERE emp_id = ?";
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = conn.prepareStatement(updateTableSQL);
                    preparedStatement.setString(1, t.getNewValue());
                    preparedStatement.setInt(2, emp_id);
                    preparedStatement.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(show_table_member.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        TableColumn<Employee, Boolean> tc3 = new TableColumn<>("isAdmin");
        tc3.setPrefWidth(200);
        tc3.setCellValueFactory(new PropertyValueFactory("admin"));
        tc3.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Boolean>() {
            @Override
            public String toString(Boolean object) {
                return object.toString();
            }

            @Override
            public Boolean fromString(String string) {
                return Boolean.parseBoolean(string);
            }
        }));
        tc3.setOnEditCommit(t -> {
            t.getRowValue().setAdmin(t.getNewValue());

            int emp_id = t.getRowValue().getEmp_id();
            conn = db.getConn();
            String updateTableSQL = "UPDATE employee SET isAdmin = ? WHERE emp_id = ?";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = conn.prepareStatement(updateTableSQL);
                boolean isAdmin = t.getNewValue();
                int admin = 0;
                if(isAdmin){
                    admin=1;
                }
                preparedStatement.setInt(1, admin);
                preparedStatement.setInt(2, emp_id);
                preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(show_table_member.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        TableColumn tc4 = new TableColumn("emp_address");
        tc4.setPrefWidth(200);
        tc4.setCellValueFactory(new PropertyValueFactory("emp_address"));
        tc4.setCellFactory(cellFactory);
        tc4.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, String> t) {
                ((Employee) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setEmp_name(t.getNewValue());

                int emp_id = table_emp.getSelectionModel().getSelectedItem().getEmp_id();
                String updateTableSQL = "UPDATE employee SET address = ? WHERE emp_id = ?";
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = conn.prepareStatement(updateTableSQL);
                    preparedStatement.setString(1, t.getNewValue());
                    preparedStatement.setInt(2, emp_id);
                    preparedStatement.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(show_table_member.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        TableColumn tc5 = new TableColumn("emp_email");
        tc5.setPrefWidth(200);
        tc5.setCellValueFactory(new PropertyValueFactory("emp_email"));
        tc5.setCellFactory(cellFactory);
        tc5.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, String> t) {
                ((Employee) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setEmp_name(t.getNewValue());

                int emp_id = table_emp.getSelectionModel().getSelectedItem().getEmp_id();
                String updateTableSQL = "UPDATE employee SET email = ? WHERE emp_id = ?";
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = conn.prepareStatement(updateTableSQL);
                    preparedStatement.setString(1, t.getNewValue());
                    preparedStatement.setInt(2, emp_id);
                    preparedStatement.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(show_table_member.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        table_emp.setItems(ob);
        table_emp.getColumns().addAll(tc1, tc2, tc3, tc4, tc5);
        table_emp.setMaxSize(800, 1000);

        return table_emp;

    }

    class EditingCell extends TableCell<Employee, String> {

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
