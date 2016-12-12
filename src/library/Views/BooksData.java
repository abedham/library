/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import library.AllClass.EmpBook;

/**
 *
 * @author AbdelRahman
 */
public class BooksData extends VBox {

    private boolean admin;

    private final int minWidth = 200;
    private final int minWidthLabels = 115;
    private final int spacing = 15;
    private final int padding = 10;

    private ObservableList<EmpBook> data = FXCollections.observableArrayList();
    private TableView<EmpBook> tableView = new TableView<>(data);

    private TableColumn<EmpBook, Integer> tcBookID = new TableColumn("Book id");
    private TableColumn<EmpBook, String> tcBookName = new TableColumn("Book Name");
    private TableColumn<EmpBook, String> tcSectionName = new TableColumn("Section name");
    private TableColumn<EmpBook, String> tcRegBy = new TableColumn("Registerd by");
    private TableColumn<EmpBook, String> tcRegDate = new TableColumn("Registered at");
    private TableColumn<EmpBook, String> tcAvailable = new TableColumn("Status");

    TextField filterField = new TextField();

    public BooksData() {
        initBooksDataView();
    }

    private void initTableView() {
        // 0. Initialize the columns.

        tableView.setMaxWidth(minWidth + minWidthLabels + 340);

        tableView.getColumns().addAll(tcBookID, tcBookName, tcSectionName, tcRegBy, tcRegDate);

        tcBookID.setCellValueFactory(new PropertyValueFactory("bookId"));
        tcBookName.setCellValueFactory(new PropertyValueFactory("bookName"));
        tcSectionName.setCellValueFactory(new PropertyValueFactory("section"));
        tcRegBy.setCellValueFactory(new PropertyValueFactory("empName"));
        tcRegDate.setCellValueFactory(new PropertyValueFactory("date"));
        tcAvailable.setCellValueFactory(new PropertyValueFactory("available"));
        initSearch();

    }

    private void initSearch() {
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<EmpBook> filteredData = new FilteredList<>(data, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(empBook -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                // Does not match.

                return empBook.getBookName().toLowerCase().contains(lowerCaseFilter)
                        || empBook.getSection().toLowerCase().contains(lowerCaseFilter);
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<EmpBook> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableView.setItems(sortedData);
    }

    private void initBooksDataView() {
        initTableView();
        filterField.setPromptText("search by book or section name");
        filterField.setMinWidth(minWidth);
        filterField.setMaxWidth(minWidth);
        getChildren().addAll(filterField, tableView);
        setPadding(new Insets(padding));
        setAlignment(Pos.CENTER);
        setSpacing(spacing);
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
        if (!admin) {
            tableView.getColumns().remove(tcRegBy);
        }
    }

    public boolean isAdmin() {
        return admin;
    }

    public TextField getFilterField() {
        return filterField;
    }

    public void setFilterField(TextField filterField) {
        this.filterField = filterField;
    }

    public ObservableList<EmpBook> getData() {
        return data;
    }

    public void setData(List<EmpBook> empBooks) {
        data.clear();
        data.addAll(empBooks);
    }

    public TableView<EmpBook> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<EmpBook> tableView) {
        this.tableView = tableView;
    }

}
