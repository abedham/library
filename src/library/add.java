package library;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.AllClass.Employee;
import library.AllClass.Publisher;
import library.AllClass.Section;
import library.AllClass.member;

public class add {

    static CallableStatement callableStatement = null;
    static DBConnection db = new DBConnection();
    static Connection conn = db.getConn();
    static Statement stmt;
    static PreparedStatement preparedStatement = null;

    public static void add_Book(String title, boolean avail, int sec_id, int pub_id, List<String> Author_name, int emp_id) {

        try {
            stmt = conn.createStatement();
            String std_count = "{call addBook(?,?,?,?,? ,? , ?)}";
            callableStatement = conn.prepareCall(std_count);

            callableStatement.setString(1, title);
            callableStatement.setBoolean(2, avail);
            callableStatement.setInt(3, sec_id);
            callableStatement.setInt(4, pub_id);
            callableStatement.setString(5, Author_name.get(0));
            callableStatement.setInt(6, emp_id);

            callableStatement.registerOutParameter(7, java.sql.Types.NUMERIC);
            callableStatement.executeUpdate();

            int B_id = callableStatement.getInt(7);

            PreparedStatement preparedStatement = null;

            for (int i = 1; i < Author_name.size(); i++) {
                String sql_addAuthor = "insert into Author_Book values(? , ?)";
                preparedStatement = conn.prepareStatement(sql_addAuthor);
                preparedStatement.setString(1, Author_name.get(i));
                preparedStatement.setInt(2, B_id);
                preparedStatement.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static member add_Member(String name, String email, List<String> phone, int Emp_id, String address, String expire_date) {
        member member = null;
        try {
            stmt = conn.createStatement();
            String std_count = "{call addMember(?,?,?,?,? ,? , ?)}";
            callableStatement = conn.prepareCall(std_count);

            callableStatement.setString(1, name);
            callableStatement.setString(2, email);
            callableStatement.setString(3, phone.get(0));
            callableStatement.setInt(4, Emp_id);
            callableStatement.setString(5, address);
            callableStatement.setString(6, expire_date);
            callableStatement.registerOutParameter(7, java.sql.Types.NUMERIC);

            callableStatement.executeUpdate();

            int mem_id = callableStatement.getInt(7);
            member = new member(mem_id, name, email, address, expire_date);
            String sql_addAuthor = "insert into phone_number values(? , ?)";
            preparedStatement = conn.prepareStatement(sql_addAuthor);
            for (int i = 1; i < phone.size(); i++) {

                preparedStatement.setInt(1, mem_id);
                preparedStatement.setString(2, phone.get(i));
                preparedStatement.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
        return member;
    }

    public static Publisher add_Publisher(String name, String address) {
        Publisher publisher = null;
        String add_pub = "{call add_Publisher(?,?,?)}";
        try {
            callableStatement = conn.prepareCall(add_pub);
            callableStatement.setString(1, name);
            callableStatement.setString(2, address);
            callableStatement.registerOutParameter(3, Types.NUMERIC);

            callableStatement.executeUpdate();
            int id = callableStatement.getInt(3);
            publisher = new Publisher(id, name, address);
        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
        return publisher;
    }

    public static void Borrow_Book(int emp_id, int mem_id, int book_id, String expire_date) {

        String Borrow_Book = "{call Borrow_Book(?,?,?)}";
        try {
            callableStatement = conn.prepareCall(Borrow_Book);
            callableStatement.setInt(1, emp_id);
            callableStatement.setInt(2, mem_id);
            callableStatement.setInt(3, book_id);
            callableStatement.setString(4, expire_date);

            callableStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Section add_section(String sec_name) {
        Section section = null;
        String add_Section = "{call add_Section(?,?)}";
        try {
            callableStatement = conn.prepareCall(add_Section);
            callableStatement.setString(1, sec_name);
            callableStatement.registerOutParameter(2, Types.NUMERIC);
            callableStatement.executeUpdate();
            int sec_id = callableStatement.getInt(2);
            section = new Section(sec_id, sec_name);
        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
        return section;
    }

    public static Employee add_employee(String name, String address, boolean isAdmin, String email, int salary) {
        Employee emp = null;
        try {

            String add_employee = "{call ADD_EMP(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(add_employee);
            callableStatement.setString(1, name);
            callableStatement.setBoolean(2, isAdmin);
            callableStatement.setString(3, address);
            callableStatement.setString(4, email);
            callableStatement.setInt(5, salary);
            callableStatement.registerOutParameter(6, Types.NUMERIC);

            callableStatement.executeUpdate();
            int id = callableStatement.getInt(6);
            emp = new Employee(id, name, isAdmin, address, email, salary);

        } catch (SQLException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emp;
    }
}
