package library.show;

import library.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.AllClass.Employee;
import library.AllClass.book;
import library.AllClass.Member;
import library.AllClass.borrow;
import library.AllClass.Author_book;
import library.AllClass.phone_number;
import library.AllClass.Publisher;
import library.AllClass.BookRegisteration;
import library.AllClass.Reg_member;
import library.AllClass.Section;
import library.AllClass.Supplies;

public class show_data {

    static DBConnection db = new DBConnection();
    static Connection conn = db.getConn();
    static Statement stat = null;

    ////////       Employee     ////////////////////
    ArrayList<Employee> A_emp;
    ObservableList<Employee> data_emp;

    ///////////////////////////////////////////////
    ////////       book     ////////////////////
    ArrayList<book> A_book;
    ObservableList<book> data_book;

    ///////////////////////////////////////////////
    ////////       Member     ////////////////////
    ArrayList<Member> A_mem;
    ObservableList<Member> data_mem;
    ///////////////////////////////////////////////

    //////////       borrow_book     ////////////////////
    ArrayList<borrow> A_borrow;
    ObservableList<borrow> data_borrow;
    ///////////////////////////////////////////////

    //////////       Auhtor_book     ////////////////////
    ArrayList<Author_book> A_Auth_book;
    ObservableList<Author_book> data_Auth_book;
    ///////////////////////////////////////////////

    //////////       phone_number     ////////////////////
    ArrayList<phone_number> A_phone_mem;
    ObservableList<phone_number> data_phone_mem;
    ///////////////////////////////////////////////

    //////////       publisher     ////////////////////
    ArrayList<Publisher> A_pub;
    ObservableList<Publisher> data_pub;
    ///////////////////////////////////////////////

    //////////       reg_book     ////////////////////
    ArrayList<BookRegisteration> A_reg_book;
    ObservableList<BookRegisteration> data_reg_book;
    ///////////////////////////////////////////////

    //////////       reg_member     ////////////////////
    ArrayList<Reg_member> A_reg_mem;
    ObservableList<Reg_member> data_reg_mem;
    ///////////////////////////////////////////////

    //////////       section     ////////////////////
    ArrayList<Section> A_sec;
    ObservableList<Section> data_sec;
    ///////////////////////////////////////////////

    //////////       supplies     ////////////////////
    ArrayList<Supplies> A_sup;
    ObservableList<Supplies> data_sup;
    ///////////////////////////////////////////////

    public ObservableList emp_show() {

        try {
            A_emp = new ArrayList<>();
            data_emp = FXCollections.observableArrayList();
            String sql = "select * from employee";
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                A_emp.add(new Employee(rs.getInt("emp_id"), rs.getString("name"), rs.getBoolean("isAdmin"),
                        rs.getString("address"), rs.getString("email"), rs.getInt("salary")));
            }

            data_emp.removeAll(data_emp);
            for (int i = 0; i < A_emp.size(); i++) {
                data_emp.add(new Employee(A_emp.get(i).getEmp_id(), A_emp.get(i).getEmp_name(),
                        A_emp.get(i).isAdmin(), A_emp.get(i).getEmp_address(), A_emp.get(i).getEmp_email(), A_emp.get(i).getSalary()));
            }

        } catch (SQLException ex) {
            Logger.getLogger(show_data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data_emp;

    }

    public ObservableList book_show() throws SQLException {

        A_book = new ArrayList<>();
        data_book = FXCollections.observableArrayList();
        String sql = "select * from book";
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while (rs.next()) {
            A_book.add(new book(rs.getInt("book_id"), rs.getString("title"), rs.getBoolean("available"),
                    rs.getInt("sec_id")));
        }

        data_book.removeAll(data_book);
        for (int i = 0; i < A_book.size(); i++) {
            data_book.add(new book(A_book.get(i).getBook_id(), A_book.get(i).getTitle(),
                    A_book.get(i).getAvailable(), A_book.get(i).getSec_id()));
        }

        return data_book;
    }

    public ObservableList member_show() {

        try {
            A_mem = new ArrayList<>();
            data_mem = FXCollections.observableArrayList();
            String sql = "select * from MEM_EMP";
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                A_mem.add(new Member(rs.getInt("mem_id"), rs.getString("EMP_NAME"), rs.getString("MEM_NAME"), rs.getString("email"),
                        rs.getString("address"), rs.getString("expire_date")));

            }

            data_mem.removeAll(data_mem);
            for (int i = 0; i < A_mem.size(); i++) {

                data_mem.add(new Member(A_mem.get(i).getMem_id(), A_mem.get(i).getEmpName(), A_mem.get(i).getName(),
                        A_mem.get(i).getEmail(), A_mem.get(i).getAddress(), A_mem.get(i).getExpire_date()));
            }

            return data_mem;
        } catch (SQLException ex) {
            Logger.getLogger(show_data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ObservableList borrow_show() throws SQLException {

        A_borrow = new ArrayList<>();
        data_borrow = FXCollections.observableArrayList();
        String sql = "select * from borrow";
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while (rs.next()) {

            A_borrow.add(new borrow(rs.getInt("emp_id"), rs.getInt("mem_id"), rs.getInt("book_id"),
                    rs.getString("cur_date"), rs.getString("expire_date")));
        }

        data_borrow.removeAll(data_borrow);
        for (int i = 0; i < A_borrow.size(); i++) {

            data_borrow.add(new borrow(A_borrow.get(i).getEmp_id(), A_borrow.get(i).getMem_id(), A_borrow.get(i).getBook_id(),
                    A_borrow.get(i).getCur_date(), A_borrow.get(i).getExpire_date()));
        }

        return data_borrow;
    }

    public ObservableList Author_book_show() throws SQLException {

        A_Auth_book = new ArrayList<>();
        data_Auth_book = FXCollections.observableArrayList();
        String sql = "select * from Author_book";
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while (rs.next()) {

            A_Auth_book.add(new Author_book(rs.getString("Author_name"), rs.getInt("book_id")));
        }

        data_Auth_book.removeAll(data_Auth_book);
        for (int i = 0; i < A_Auth_book.size(); i++) {

            data_Auth_book.add(new Author_book(A_Auth_book.get(i).getAuthor_name(), A_Auth_book.get(i).getBook_id()));
        }

        return data_Auth_book;
    }

    public ObservableList Phone_mem_show() throws SQLException {

        A_phone_mem = new ArrayList<>();
        data_phone_mem = FXCollections.observableArrayList();
        String sql = "select * from phone_number";
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while (rs.next()) {

            A_phone_mem.add(new phone_number(rs.getInt("mem_id"), rs.getInt("phone")));
        }

        data_phone_mem.removeAll(data_phone_mem);
        for (int i = 0; i < A_phone_mem.size(); i++) {
            data_phone_mem.add(new phone_number(A_phone_mem.get(i).getMem_id(), A_phone_mem.get(i).getPhone()));
        }

        return data_phone_mem;
    }

    public ObservableList publisher_show() {

        try {
            A_pub = new ArrayList<>();
            data_pub = FXCollections.observableArrayList();
            String sql = "select * from publisher";
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {

                A_pub.add(new Publisher(rs.getInt("pub_id"), rs.getString("name"), rs.getString("address")));

            }

            data_pub.clear();
            for (int i = 0; i < A_pub.size(); i++) {
                data_pub.add(new Publisher(A_pub.get(i).getId(), A_pub.get(i).getName(),
                        A_pub.get(i).getAddress()));
            }

        } catch (SQLException ex) {
            Logger.getLogger(show_data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data_pub;
    }

    public ObservableList reg_book_show() throws SQLException {

        A_reg_book = new ArrayList<>();
        data_reg_book = FXCollections.observableArrayList();
        String sql = "select * from reg_book";
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while (rs.next()) {

            A_reg_book.add(new BookRegisteration(rs.getInt("emp_id"), rs.getInt("book_id"), rs.getString("cur_date")));

        }

        data_reg_book.removeAll(data_reg_book);
        for (int i = 0; i < A_reg_book.size(); i++) {
            data_reg_book.add(new BookRegisteration(A_reg_book.get(i).getId(), A_reg_book.get(i).getId(), A_reg_book.get(i).getCurrentDate()));
        }

        return data_reg_book;
    }

    public ObservableList reg_member_show() throws SQLException {

        A_reg_mem = new ArrayList<>();
        data_reg_mem = FXCollections.observableArrayList();
        String sql = "select * from reg_member";
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while (rs.next()) {

            A_reg_mem.add(new Reg_member(rs.getInt("emp_id"), rs.getInt("mem_id"), rs.getString("cur_date"), rs.getString("expire_date")));

        }

        data_reg_mem.removeAll(data_reg_mem);
        for (int i = 0; i < A_reg_mem.size(); i++) {
            data_reg_mem.add(new Reg_member(A_reg_mem.get(i).getEmp_id(), A_reg_mem.get(i).getMem_id(), A_reg_mem.get(i).getCur_date(), A_reg_mem.get(i).getExpire_date()));
        }

        return data_reg_mem;
    }

    public ObservableList Section_show() {

        try {
            A_sec = new ArrayList<>();
            data_sec = FXCollections.observableArrayList();
            String sql = "select * from section";
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {

                A_sec.add(new Section(rs.getInt("sec_id"), rs.getString("name")));

            }

            data_sec.removeAll(data_sec);
            for (int i = 0; i < A_sec.size(); i++) {
                data_sec.add(new Section(A_sec.get(i).getSec_id(), A_sec.get(i).getSec_name()));
            }

        } catch (SQLException ex) {
            Logger.getLogger(show_data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data_sec;
    }

    public ObservableList supplies_show() throws SQLException {

        A_sup = new ArrayList<>();
        data_sup = FXCollections.observableArrayList();
        String sql = "select * from supplies";
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while (rs.next()) {

            A_sup.add(new Supplies(rs.getInt("pub_id"), rs.getInt("book_id")));

        }

        data_sup.removeAll(data_sup);
        for (int i = 0; i < A_sup.size(); i++) {
            data_sup.add(new Supplies(A_sup.get(i).getPub_id(), A_sup.get(i).getBook_id()));
        }

        return data_sup;
    }

    //////////////////////////////////////////////////
}
